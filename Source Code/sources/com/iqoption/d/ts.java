package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentVideoEducationVideosBindingImpl */
public class ts extends tr {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.headerLayout, 1);
        awV.put(R.id.btnBack, 2);
        awV.put(R.id.btnSearch, 3);
        awV.put(R.id.titleLayout, 4);
        awV.put(R.id.title, 5);
        awV.put(R.id.searchLayout, 6);
        awV.put(R.id.searchInput, 7);
        awV.put(R.id.btnCloseSearch, 8);
        awV.put(R.id.tagsList, 9);
        awV.put(R.id.videosList, 10);
    }

    public ts(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private ts(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (TextView) objArr[8], (ImageView) objArr[3], (FrameLayout) objArr[1], (EditText) objArr[7], (LinearLayout) objArr[6], (RecyclerView) objArr[9], (TextView) objArr[5], (FrameLayout) objArr[4], (RecyclerView) objArr[10]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.awW != 0) {
                return true;
            }
            return false;
        }
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
    }
}
