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

/* compiled from: PortfolioCfdInfoBindingImpl */
public class aeb extends aea {
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
        awV.put(R.id.openTime, 3);
        awV.put(R.id.openPriceLayout, 4);
        awV.put(R.id.openPrice, 5);
        awV.put(R.id.investmentLayout, 6);
        awV.put(R.id.investment, 7);
        awV.put(R.id.quantityLayout, 8);
        awV.put(R.id.quantity, 9);
        awV.put(R.id.currentPrice, 10);
        awV.put(R.id.takeProfitLayout, 11);
        awV.put(R.id.takeProfit, 12);
        awV.put(R.id.stopLossLayout, 13);
        awV.put(R.id.stopLossTitle, 14);
        awV.put(R.id.stopLoss, 15);
        awV.put(R.id.marginLayout, 16);
        awV.put(R.id.marginTitle, 17);
        awV.put(R.id.marginPercente, 18);
        awV.put(R.id.commissionLayout, 19);
        awV.put(R.id.commissionValue, 20);
        awV.put(R.id.swapLayout, 21);
        awV.put(R.id.btnClose, 22);
        awV.put(R.id.btnCloseLabel, 23);
        awV.put(R.id.btnCloseProgress, 24);
        awV.put(R.id.btnEdit, 25);
        awV.put(R.id.btnWithdraw, 26);
        awV.put(R.id.btnWithdrawLabel, 27);
        awV.put(R.id.btnWithdrawProgress, 28);
    }

    public aeb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 29, awU, awV));
    }

    private aeb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[22], (TextView) objArr[23], (ProgressBar) objArr[24], (ImageView) objArr[25], (FrameLayout) objArr[26], (TextView) objArr[27], (ProgressBar) objArr[28], (LinearLayout) objArr[19], (RobotoTextView) objArr[20], (RobotoTextView) objArr[10], (ImageView) objArr[1], (RobotoTextView) objArr[7], (LinearLayout) objArr[6], (LinearLayout) objArr[16], (RobotoTextView) objArr[18], (TextView) objArr[17], (RobotoTextView) objArr[5], (LinearLayout) objArr[4], (RobotoTextView) objArr[3], (RobotoTextView) objArr[9], (LinearLayout) objArr[8], (RobotoTextView) objArr[15], (LinearLayout) objArr[13], (TextView) objArr[14], (LinearLayout) objArr[21], (RobotoTextView) objArr[2], (RobotoTextView) objArr[12], (LinearLayout) objArr[11]);
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
