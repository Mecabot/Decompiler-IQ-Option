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

/* compiled from: RightPanelDelegateCryptoMainBindingImpl */
public class aid extends aic {
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
        awV.put(R.id.amountLabel, 4);
        awV.put(R.id.amountValue, 5);
        awV.put(R.id.amountPicker, 6);
        awV.put(R.id.insidePendingLayout, 7);
        awV.put(R.id.pendingLabel, 8);
        awV.put(R.id.pendingValue, 9);
        awV.put(R.id.pendingPicker, 10);
        awV.put(R.id.callPut, 11);
        awV.put(R.id.buttonCall, 12);
        awV.put(R.id.callIconLayout, 13);
        awV.put(R.id.arrowBuy, 14);
        awV.put(R.id.paddingIconBuy, 15);
        awV.put(R.id.askValue, 16);
        awV.put(R.id.spreadLabel, 17);
        awV.put(R.id.spreadValue, 18);
        awV.put(R.id.buttonPut, 19);
        awV.put(R.id.putIconLayout, 20);
        awV.put(R.id.arrowSell, 21);
        awV.put(R.id.paddingIconSell, 22);
        awV.put(R.id.bidValue, 23);
    }

    public aid(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 24, awU, awV));
    }

    private aid(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (FrameLayout) objArr[1], (ImageView) objArr[6], (RobotoTextView) objArr[5], (ImageView) objArr[14], (ImageView) objArr[21], (NumberAnimateRobotoTextView) objArr[16], (NumberAnimateRobotoTextView) objArr[23], (LinearLayout) objArr[12], (LinearLayout) objArr[19], (FrameLayout) objArr[13], (MaxSizeLinearLayout) objArr[11], (ImageView) objArr[3], (LinearLayout) objArr[7], (ImageView) objArr[15], (ImageView) objArr[22], (TextView) objArr[8], (FrameLayout) objArr[2], (ImageView) objArr[10], (RobotoTextView) objArr[9], (FrameLayout) objArr[20], (TextView) objArr[17], (NumberAnimateRobotoTextView) objArr[18]);
        this.awW = -1;
        this.bRh.setTag(null);
        this.bRs.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
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
            a.d(this.bRG, 0.5f);
        }
    }
}
