package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: PortfolioExpInfoBindingImpl */
public class aes extends aer {
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
        awV.put(R.id.optPriceLayout, 1);
        awV.put(R.id.optPrice, 2);
        awV.put(R.id.qttyLayout, 3);
        awV.put(R.id.qtty, 4);
        awV.put(R.id.expLayout, 5);
        awV.put(R.id.expTime, 6);
        awV.put(R.id.expProfit, 7);
        awV.put(R.id.investment, 8);
        awV.put(R.id.currentPrice, 9);
        awV.put(R.id.pnlSell, 10);
        awV.put(R.id.btnSell, 11);
        awV.put(R.id.btnSellLabel, 12);
        awV.put(R.id.btnSellProgress, 13);
    }

    public aes(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, awU, awV));
    }

    private aes(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[11], (TextView) objArr[12], (ProgressBar) objArr[13], (RobotoTextView) objArr[9], (LinearLayout) objArr[5], (RobotoTextView) objArr[7], (RobotoTextView) objArr[6], (RobotoTextView) objArr[8], (RobotoTextView) objArr[2], (LinearLayout) objArr[1], (RobotoTextView) objArr[10], (RobotoTextView) objArr[4], (LinearLayout) objArr[3]);
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
