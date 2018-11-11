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

/* compiled from: OpenCfdItemBindingImpl */
public class acf extends ace {
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
        awV.put(R.id.multiplyValue, 2);
        awV.put(R.id.totalValue, 3);
        awV.put(R.id.profitValue, 4);
        awV.put(R.id.openPrice, 5);
        awV.put(R.id.currentPrice, 6);
        awV.put(R.id.takeProfitLayout, 7);
        awV.put(R.id.takeProfit, 8);
        awV.put(R.id.stopLossLayout, 9);
        awV.put(R.id.stopLoss, 10);
        awV.put(R.id.sellButton, 11);
        awV.put(R.id.buybackOptionProgress, 12);
        awV.put(R.id.editButton, 13);
    }

    public acf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, awU, awV));
    }

    private acf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ContentLoadingProgressBar) objArr[12], (RobotoTextView) objArr[6], (ImageView) objArr[13], (RobotoTextView) objArr[1], (RobotoTextView) objArr[2], (LinearLayout) objArr[0], (RobotoTextView) objArr[5], (RobotoTextView) objArr[4], (TextView) objArr[11], (RobotoTextView) objArr[10], (LinearLayout) objArr[9], (RobotoTextView) objArr[8], (LinearLayout) objArr[7], (RobotoTextView) objArr[3]);
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
