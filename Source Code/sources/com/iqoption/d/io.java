package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: DialogGdprWarningBindingImpl */
public class io extends in {
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
        awV.put(R.id.gdprContainer, 1);
        awV.put(R.id.gdprSpaceTop, 2);
        awV.put(R.id.gdprWarningIcon, 3);
        awV.put(R.id.gdprSpaceMiddle, 4);
        awV.put(R.id.gdprWarningTitle, 5);
        awV.put(R.id.gdprWarningText, 6);
        awV.put(R.id.gdprSpaceBottom, 7);
        awV.put(R.id.gdprConfirm, 8);
        awV.put(R.id.gdprConfirmProgress, 9);
    }

    public io(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, awU, awV));
    }

    private io(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[0], (TextView) objArr[8], (ContentLoadingProgressBar) objArr[9], (LinearLayout) objArr[1], (Space) objArr[7], (Space) objArr[4], (Space) objArr[2], (ImageView) objArr[3], (TextView) objArr[6], (TextView) objArr[5]);
        this.awW = -1;
        this.bjF.setTag(null);
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
