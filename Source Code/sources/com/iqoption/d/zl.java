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
import com.iqoption.core.ui.a;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: MicroPortfolioCfdInfoBindingImpl */
public class zl extends zk {
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
        awV.put(R.id.investLayout, 3);
        awV.put(R.id.investment, 4);
        awV.put(R.id.multiplierLayout, 5);
        awV.put(R.id.multiplier, 6);
        awV.put(R.id.quantityLayout, 7);
        awV.put(R.id.quantity, 8);
        awV.put(R.id.openPriceLayout, 9);
        awV.put(R.id.openPrice, 10);
        awV.put(R.id.currentPrice, 11);
        awV.put(R.id.takeProfitLayout, 12);
        awV.put(R.id.takeProfitPercent, 13);
        awV.put(R.id.stopLossLayout, 14);
        awV.put(R.id.stopLossTitle, 15);
        awV.put(R.id.stopLossPercent, 16);
        awV.put(R.id.marginLayout, 17);
        awV.put(R.id.marginTitle, 18);
        awV.put(R.id.marginPercent, 19);
        awV.put(R.id.commissionLayout, 20);
        awV.put(R.id.commissionValue, 21);
        awV.put(R.id.swapLayout, 22);
        awV.put(R.id.btnClose, 23);
        awV.put(R.id.btnCloseLabel, 24);
        awV.put(R.id.btnCloseProgress, 25);
        awV.put(R.id.btnEdit, 26);
        awV.put(R.id.btnWithdraw, 27);
        awV.put(R.id.btnWithdrawLabel, 28);
        awV.put(R.id.btnWithdrawProgress, 29);
    }

    public zl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 30, awU, awV));
    }

    private zl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[23], (TextView) objArr[24], (ProgressBar) objArr[25], (ImageView) objArr[26], (FrameLayout) objArr[27], (ImageView) objArr[28], (ProgressBar) objArr[29], (LinearLayout) objArr[20], (RobotoTextView) objArr[21], (RobotoTextView) objArr[11], (ImageView) objArr[1], (LinearLayout) objArr[3], (RobotoTextView) objArr[4], (LinearLayout) objArr[17], (RobotoTextView) objArr[19], (TextView) objArr[18], (RobotoTextView) objArr[6], (LinearLayout) objArr[5], (RobotoTextView) objArr[10], (LinearLayout) objArr[9], (RobotoTextView) objArr[8], (LinearLayout) objArr[7], (LinearLayout) objArr[14], (RobotoTextView) objArr[16], (TextView) objArr[15], (LinearLayout) objArr[22], (RobotoTextView) objArr[2], (LinearLayout) objArr[12], (RobotoTextView) objArr[13]);
        this.awW = -1;
        this.bLx.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.bEe.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            Void voidR = (Void) null;
            a.a(this.bLx, voidR);
            a.a(this.bEe, voidR);
        }
    }
}
