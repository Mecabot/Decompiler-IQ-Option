package android.support.v7.recyclerview.extensions;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.recyclerview.extensions.AsyncDifferConfig.Builder;
import android.support.v7.util.AdapterListUpdateCallback;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.Callback;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.util.DiffUtil.ItemCallback;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.Collections;
import java.util.List;

public class AsyncListDiffer<T> {
    private final AsyncDifferConfig<T> mConfig;
    @Nullable
    private List<T> mList;
    private int mMaxScheduledGeneration;
    @NonNull
    private List<T> mReadOnlyList = Collections.emptyList();
    private final ListUpdateCallback mUpdateCallback;

    public AsyncListDiffer(@NonNull Adapter adapter, @NonNull ItemCallback<T> itemCallback) {
        this.mUpdateCallback = new AdapterListUpdateCallback(adapter);
        this.mConfig = new Builder(itemCallback).build();
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void submitList(final List<T> list) {
        if (list != this.mList) {
            final int i = this.mMaxScheduledGeneration + 1;
            this.mMaxScheduledGeneration = i;
            if (list == null) {
                int size = this.mList.size();
                this.mList = null;
                this.mReadOnlyList = Collections.emptyList();
                this.mUpdateCallback.onRemoved(0, size);
            } else if (this.mList == null) {
                this.mList = list;
                this.mReadOnlyList = Collections.unmodifiableList(list);
                this.mUpdateCallback.onInserted(0, list.size());
            } else {
                final List list2 = this.mList;
                this.mConfig.getBackgroundThreadExecutor().execute(new Runnable() {
                    public void run() {
                        final DiffResult calculateDiff = DiffUtil.calculateDiff(new Callback() {
                            public int getOldListSize() {
                                return list2.size();
                            }

                            public int getNewListSize() {
                                return list.size();
                            }

                            public boolean areItemsTheSame(int i, int i2) {
                                return AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(list2.get(i), list.get(i2));
                            }

                            public boolean areContentsTheSame(int i, int i2) {
                                return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(list2.get(i), list.get(i2));
                            }

                            @Nullable
                            public Object getChangePayload(int i, int i2) {
                                return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(list2.get(i), list.get(i2));
                            }
                        });
                        AsyncListDiffer.this.mConfig.getMainThreadExecutor().execute(new Runnable() {
                            public void run() {
                                if (AsyncListDiffer.this.mMaxScheduledGeneration == i) {
                                    AsyncListDiffer.this.latchList(list, calculateDiff);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    private void latchList(@NonNull List<T> list, @NonNull DiffResult diffResult) {
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
    }
}
