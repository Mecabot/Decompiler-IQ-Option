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
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.core.ui.widget.MaxSizeLinearLayout;
import com.iqoption.view.BuyNewDialogView;
import com.iqoption.view.NumberAnimateRobotoTextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateCfdMainBindingImpl */
public class ahp extends aho {
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
        awV.put(R.id.expirationContainer, 5);
        awV.put(R.id.expirationLabel, 6);
        awV.put(R.id.expirationValue, 7);
        awV.put(R.id.expirationPicker, 8);
        awV.put(R.id.amountLabel, 9);
        awV.put(R.id.amountValue, 10);
        awV.put(R.id.amountPicker, 11);
        awV.put(R.id.multiplierTotalLayout, 12);
        awV.put(R.id.multiplierHighlighter, 13);
        awV.put(R.id.multiplierLabel, 14);
        awV.put(R.id.multiplierValue, 15);
        awV.put(R.id.multiplierPicker, 16);
        awV.put(R.id.totalContainerAmount, 17);
        awV.put(R.id.totalLabel, 18);
        awV.put(R.id.totalValue, 19);
        awV.put(R.id.insidePendingLayout, 20);
        awV.put(R.id.pendingLabel, 21);
        awV.put(R.id.pendingValue, 22);
        awV.put(R.id.pendingPicker, 23);
        awV.put(R.id.callPut, 24);
        awV.put(R.id.buttonCall, 25);
        awV.put(R.id.callIconLayout, 26);
        awV.put(R.id.arrowBuy, 27);
        awV.put(R.id.paddingIconBuy, 28);
        awV.put(R.id.askValue, 29);
        awV.put(R.id.spreadLabel, 30);
        awV.put(R.id.spreadValue, 31);
        awV.put(R.id.buttonPut, 32);
        awV.put(R.id.putIconLayout, 33);
        awV.put(R.id.arrowSell, 34);
        awV.put(R.id.paddingIconSell, 35);
        awV.put(R.id.bidValue, 36);
        awV.put(R.id.buyNewDialog, 37);
    }

    public ahp(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 38, awU, awV));
    }

    private ahp(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (FrameLayout) objArr[1], (ImageView) objArr[11], (RobotoTextView) objArr[10], (ImageView) objArr[27], (ImageView) objArr[34], (NumberAnimateRobotoTextView) objArr[29], (NumberAnimateRobotoTextView) objArr[36], (LinearLayout) objArr[25], (LinearLayout) objArr[32], (BuyNewDialogView) objArr[37], (FrameLayout) objArr[26], (MaxSizeLinearLayout) objArr[24], (ImageView) objArr[4], (FrameLayout) objArr[5], (TextView) objArr[6], (ImageView) objArr[8], (RobotoTextView) objArr[7], (LinearLayout) objArr[20], (LinearLayout) objArr[0], (ImageView) objArr[13], (TextView) objArr[14], (FrameLayout) objArr[2], (ImageView) objArr[16], (LinearLayout) objArr[12], (RobotoTextView) objArr[15], (ImageView) objArr[28], (ImageView) objArr[35], (TextView) objArr[21], (FrameLayout) objArr[3], (ImageView) objArr[23], (RobotoTextView) objArr[22], (FrameLayout) objArr[33], (TextView) objArr[30], (NumberAnimateRobotoTextView) objArr[31], (LinearLayout) objArr[17], (TextView) objArr[18], (RobotoTextView) objArr[19]);
        this.awW = -1;
        this.bRh.setTag(null);
        this.bRs.setTag(null);
        this.bRx.setTag(null);
        this.bRA.setTag(null);
        this.bRG.setTag(null);
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
            a.d(this.bRh, 0.5f);
            a.a(this.bRs, (Void) null);
            a.d(this.bRA, 0.5f);
            a.d(this.bRG, 0.5f);
        }
    }
}
