package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: BottomSheetOvernightBindingImpl */
public class bn extends bm {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final CoordinatorLayout blq;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.outside, 1);
        awV.put(R.id.sheet, 2);
        awV.put(R.id.toolbar, 3);
        awV.put(R.id.titleDialog, 4);
        awV.put(R.id.closeButton, 5);
        awV.put(R.id.paramsBar, 6);
        awV.put(R.id.totalValue, 7);
        awV.put(R.id.list, 8);
        awV.put(R.id.progress, 9);
    }

    public bn(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, awU, awV));
    }

    private bn(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (RecyclerView) objArr[8], (View) objArr[1], (FrameLayout) objArr[6], (ProgressBar) objArr[9], (LinearLayout) objArr[2], (RobotoTextView) objArr[4], (RelativeLayout) objArr[3], (RobotoTextView) objArr[7]);
        this.awW = -1;
        this.blq = (CoordinatorLayout) objArr[0];
        this.blq.setTag(null);
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
