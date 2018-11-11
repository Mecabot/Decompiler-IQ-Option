package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: SellDelegateBindingImpl */
public class aiv extends aiu {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final FrameLayout biH;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.expTime, 1);
        awV.put(R.id.investTitle, 2);
        awV.put(R.id.invest, 3);
        awV.put(R.id.profitTitle, 4);
        awV.put(R.id.profit, 5);
        awV.put(R.id.sellProfitTilte, 6);
        awV.put(R.id.sellProfit, 7);
        awV.put(R.id.sellContainer, 8);
        awV.put(R.id.sell, 9);
        awV.put(R.id.progress, 10);
    }

    public aiv(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private aiv(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[4], (ContentLoadingProgressBar) objArr[10], (TextView) objArr[9], (FrameLayout) objArr[8], (TextView) objArr[7], (TextView) objArr[6]);
        this.awW = -1;
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
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
