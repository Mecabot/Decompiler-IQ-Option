package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import com.iqoption.core.i;
import com.iqoption.util.bg;

public class LinearLayoutManager2 extends LinearLayoutManager {
    private static final boolean LOCAL_DEBUG = false;
    private static final String TAG = "android.support.v7.widget.LinearLayoutManager2";

    public LinearLayoutManager2(Context context) {
        super(context);
    }

    public LinearLayoutManager2(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public LinearLayoutManager2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Throwable e) {
            i.e(TAG, "error on the layout item in the recycle view", e);
        }
    }

    int scrollBy(int i, Recycler recycler, State state) {
        if (this.mRecyclerView == null || this.mChildHelper == null) {
            return super.scrollBy(i, recycler, state);
        }
        int height = this.mRecyclerView.getHeight();
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            return super.scrollBy(i, recycler, state);
        }
        long j = 0;
        int i2 = 0;
        while (i2 < childCount) {
            i2++;
            j += (long) this.mChildHelper.getChildAt(i2).getHeight();
        }
        if (j > ((long) height)) {
            return super.scrollBy(i, recycler, state);
        }
        if (LOCAL_DEBUG) {
            i.v(TAG, "recycle view has enough space to fit all items");
        }
        float bT = bg.bT(this.mChildHelper.getChildAt(0));
        if (bT < 1.0f) {
            float height2 = (1.0f - bT) * ((float) this.mChildHelper.getChildAt(0).getHeight());
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("first item should be scrolled to ");
            stringBuilder.append(-height2);
            stringBuilder.append(", to fit");
            i.v(str, stringBuilder.toString());
            scrollToPosition(0);
        }
        if (LOCAL_DEBUG) {
            i.v(TAG, "all elements are fit, skip scroll");
        }
        return 0;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        try {
            super.collectAdjacentPrefetchPositions(i, i2, state, layoutPrefetchRegistry);
        } catch (IllegalArgumentException unused) {
            i.e(TAG, "Pixel distance must be non-negative, see https://code.google.com/p/android/issues/detail?id=230295");
        }
    }
}
