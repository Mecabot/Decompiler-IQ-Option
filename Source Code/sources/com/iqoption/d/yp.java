package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: MacroFeedOptionsBindingImpl */
public class yp extends yo {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.options_container, 4);
    }

    public yp(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, awU, awV));
    }

    private yp(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[1], (LinearLayout) objArr[4], (TextView) objArr[3], (FrameLayout) objArr[0]);
        this.awW = -1;
        this.bvL.setTag(null);
        this.bvM.setTag(null);
        this.bvO.setTag(null);
        this.bKV.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.bvL, ViewDataBinding.getDrawableFromResource(this.bvL, R.drawable.ic_copy_feed));
            TextViewBindingAdapter.setDrawableStart(this.bvM, ViewDataBinding.getDrawableFromResource(this.bvM, R.drawable.ic_no_interesting));
            TextViewBindingAdapter.setDrawableStart(this.bvO, ViewDataBinding.getDrawableFromResource(this.bvO, R.drawable.ic_share));
        }
    }
}
