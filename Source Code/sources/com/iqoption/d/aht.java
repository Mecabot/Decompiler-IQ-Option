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
import com.iqoption.view.NumberAnimateRobotoTextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateCfdOnOpenMainBindingImpl */
public class aht extends ahs {
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
        awV.put(R.id.amountLabel, 7);
        awV.put(R.id.amountValue, 8);
        awV.put(R.id.amountPicker, 9);
        awV.put(R.id.multiplierTotalLayout, 10);
        awV.put(R.id.multiplierHighlighter, 11);
        awV.put(R.id.multiplierLabel, 12);
        awV.put(R.id.multiplierValue, 13);
        awV.put(R.id.multiplierPicker, 14);
        awV.put(R.id.totalLabel, 15);
        awV.put(R.id.totalValue, 16);
        awV.put(R.id.insidePendingLayout, 17);
        awV.put(R.id.pendingLabel, 18);
        awV.put(R.id.pendingValue, 19);
        awV.put(R.id.pendingPicker, 20);
        awV.put(R.id.callPut, 21);
        awV.put(R.id.buttonCall, 22);
        awV.put(R.id.callIconLayout, 23);
        awV.put(R.id.arrowBuy, 24);
        awV.put(R.id.paddingIconBuy, 25);
        awV.put(R.id.spreadLabel, 26);
        awV.put(R.id.spreadValue, 27);
        awV.put(R.id.buttonPut, 28);
        awV.put(R.id.putIconLayout, 29);
        awV.put(R.id.arrowSell, 30);
        awV.put(R.id.paddingIconSell, 31);
    }

    public aht(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 32, awU, awV));
    }

    private aht(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[7], (FrameLayout) objArr[1], (TextView) objArr[2], (ImageView) objArr[9], (TextView) objArr[3], (RobotoTextView) objArr[8], (ImageView) objArr[24], (ImageView) objArr[30], (LinearLayout) objArr[22], (LinearLayout) objArr[28], (FrameLayout) objArr[23], (MaxSizeLinearLayout) objArr[21], (ImageView) objArr[6], (LinearLayout) objArr[17], (ImageView) objArr[11], (TextView) objArr[12], (FrameLayout) objArr[4], (ImageView) objArr[14], (LinearLayout) objArr[10], (RobotoTextView) objArr[13], (ImageView) objArr[25], (ImageView) objArr[31], (TextView) objArr[18], (FrameLayout) objArr[5], (ImageView) objArr[20], (RobotoTextView) objArr[19], (FrameLayout) objArr[29], (TextView) objArr[26], (NumberAnimateRobotoTextView) objArr[27], (TextView) objArr[15], (RobotoTextView) objArr[16]);
        this.awW = -1;
        this.bRh.setTag(null);
        this.bRM.setTag(null);
        this.bRN.setTag(null);
        this.bRs.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
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
            a.d(this.bRM, 0.5f);
            a.d(this.bRN, 0.5f);
            a.a(this.bRs, (Void) null);
            a.d(this.bRA, 0.5f);
            a.d(this.bRG, 0.5f);
        }
    }
}
