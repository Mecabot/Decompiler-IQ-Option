package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: OpenCryptoItemBindingImpl */
public class ach extends acg {
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
        awV.put(R.id.investValue, 1);
        awV.put(R.id.quantityValue, 2);
        awV.put(R.id.profitValue, 3);
        awV.put(R.id.openPrice, 4);
        awV.put(R.id.currentPrice, 5);
        awV.put(R.id.takeProfitLayout, 6);
        awV.put(R.id.takeProfit, 7);
        awV.put(R.id.stopLossLayout, 8);
        awV.put(R.id.stopLoss, 9);
        awV.put(R.id.sellButton, 10);
        awV.put(R.id.buybackOptionProgress, 11);
        awV.put(R.id.editButton, 12);
    }

    public ach(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private ach(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ContentLoadingProgressBar) objArr[11], (RobotoTextView) objArr[5], (ImageView) objArr[12], (RobotoTextView) objArr[1], (LinearLayout) objArr[0], (RobotoTextView) objArr[4], (RobotoTextView) objArr[3], (RobotoTextView) objArr[2], (TextView) objArr[10], (RobotoTextView) objArr[9], (LinearLayout) objArr[8], (RobotoTextView) objArr[7], (LinearLayout) objArr[6]);
        this.awW = -1;
        this.bNc.setTag(null);
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
