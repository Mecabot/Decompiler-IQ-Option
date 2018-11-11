package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: MicroPortfolioExpGroupItemBindingImpl */
public class zv extends zu {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ConstraintLayout biA;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.activeIcon, 1);
        awV.put(R.id.activeName, 2);
        awV.put(R.id.positionCount, 3);
        awV.put(R.id.value, 4);
        awV.put(R.id.instrument, 5);
        awV.put(R.id.expandIndicator, 6);
        awV.put(R.id.pnl, 7);
    }

    public zv(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private zv(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[2], (ImageView) objArr[6], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[3], (TextView) objArr[4]);
        this.awW = -1;
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
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
