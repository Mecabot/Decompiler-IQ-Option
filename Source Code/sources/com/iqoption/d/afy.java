package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: PortfolioPendingInfoBindingImpl */
public class afy extends afx {
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
        awV.put(R.id.createTimeLayout, 1);
        awV.put(R.id.createTime, 2);
        awV.put(R.id.investLayout, 3);
        awV.put(R.id.investment, 4);
        awV.put(R.id.multiplierLayout, 5);
        awV.put(R.id.multiplier, 6);
        awV.put(R.id.quantityLayout, 7);
        awV.put(R.id.quantity, 8);
        awV.put(R.id.currentPrice, 9);
        awV.put(R.id.takeProfitLayout, 10);
        awV.put(R.id.takeProfit, 11);
        awV.put(R.id.stopLossLayout, 12);
        awV.put(R.id.stopLoss, 13);
        awV.put(R.id.btnClose, 14);
        awV.put(R.id.btnCloseLabel, 15);
        awV.put(R.id.btnCloseProgress, 16);
        awV.put(R.id.btnEdit, 17);
    }

    public afy(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, awU, awV));
    }

    private afy(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[14], (TextView) objArr[15], (ProgressBar) objArr[16], (ImageView) objArr[17], (RobotoTextView) objArr[2], (LinearLayout) objArr[1], (RobotoTextView) objArr[9], (LinearLayout) objArr[3], (RobotoTextView) objArr[4], (RobotoTextView) objArr[6], (LinearLayout) objArr[5], (RobotoTextView) objArr[8], (LinearLayout) objArr[7], (RobotoTextView) objArr[13], (LinearLayout) objArr[12], (RobotoTextView) objArr[11], (LinearLayout) objArr[10]);
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
