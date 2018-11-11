package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: DepositPageBindingImpl */
public class gp extends go {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final RelativeLayout boJ;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.guideline_top, 1);
        awV.put(R.id.guideline_left, 2);
        awV.put(R.id.depositTitle, 3);
        awV.put(R.id.depositBackButton, 4);
        awV.put(R.id.depositFundsSelector, 5);
        awV.put(R.id.depositCryptoSelector, 6);
        awV.put(R.id.pageContentContainer, 7);
    }

    public gp(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private gp(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[3], (View) objArr[2], (View) objArr[1], (NestedScrollView) objArr[7]);
        this.awW = -1;
        this.boJ = (RelativeLayout) objArr[0];
        this.boJ.setTag(null);
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
