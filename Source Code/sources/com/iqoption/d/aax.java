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

/* compiled from: MicroPortfolioPendingInfoBindingImpl */
public class aax extends aaw {
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
        awV.put(R.id.createTime, 1);
        awV.put(R.id.investLayout, 2);
        awV.put(R.id.investment, 3);
        awV.put(R.id.multiplierLayout, 4);
        awV.put(R.id.multiplier, 5);
        awV.put(R.id.quantityLayout, 6);
        awV.put(R.id.quantity, 7);
        awV.put(R.id.currentPrice, 8);
        awV.put(R.id.takeProfitLayout, 9);
        awV.put(R.id.takeProfitPercent, 10);
        awV.put(R.id.stopLossLayout, 11);
        awV.put(R.id.stopLossPercent, 12);
        awV.put(R.id.btnClose, 13);
        awV.put(R.id.btnCloseLabel, 14);
        awV.put(R.id.btnCloseProgress, 15);
        awV.put(R.id.btnEdit, 16);
    }

    public aax(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, awU, awV));
    }

    private aax(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[13], (TextView) objArr[14], (ProgressBar) objArr[15], (ImageView) objArr[16], (RobotoTextView) objArr[1], (RobotoTextView) objArr[8], (LinearLayout) objArr[2], (RobotoTextView) objArr[3], (RobotoTextView) objArr[5], (LinearLayout) objArr[4], (RobotoTextView) objArr[7], (LinearLayout) objArr[6], (LinearLayout) objArr[11], (RobotoTextView) objArr[12], (LinearLayout) objArr[9], (RobotoTextView) objArr[10]);
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
