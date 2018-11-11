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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.view.NumberAnimateRobotoTextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateCryptoConfirmationBindingImpl */
public class ahz extends ahy {
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
        awV.put(R.id.cancelTitle, 5);
        awV.put(R.id.cancelIcon, 6);
        awV.put(R.id.confirmInvest, 7);
        awV.put(R.id.confirmQuantity, 8);
        awV.put(R.id.insidePendingLayout, 9);
        awV.put(R.id.pendingLabel, 10);
        awV.put(R.id.pendingValue, 11);
        awV.put(R.id.pendingPicker, 12);
        awV.put(R.id.insideLimitsLayout, 13);
        awV.put(R.id.limitsLabel, 14);
        awV.put(R.id.limitsValue, 15);
        awV.put(R.id.limitsPicker, 16);
        awV.put(R.id.globalCommissionContainer, 17);
        awV.put(R.id.commissionTitle, 18);
        awV.put(R.id.commissionContainer, 19);
        awV.put(R.id.commissionType, 20);
        awV.put(R.id.commissionAmount, 21);
        awV.put(R.id.commissionInfoRect, 22);
        awV.put(R.id.otnPicker, 23);
        awV.put(R.id.otnRewardTitle, 24);
        awV.put(R.id.otnRewardValueContainer, 25);
        awV.put(R.id.otnRewardValue, 26);
        awV.put(R.id.btnConfirmLayout, 27);
        awV.put(R.id.totalInvest, 28);
        awV.put(R.id.btnConfirm, 29);
    }

    public ahz(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 30, awU, awV));
    }

    private ahz(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (RobotoTextView) objArr[29], (LinearLayout) objArr[27], (ImageView) objArr[6], (ImageView) objArr[3], (RobotoTextView) objArr[5], (RobotoTextView) objArr[21], (LinearLayout) objArr[19], (View) objArr[22], (RobotoTextView) objArr[18], (RobotoTextView) objArr[20], (RobotoTextView) objArr[7], (LinearLayout) objArr[0], (NumberAnimateRobotoTextView) objArr[8], (RelativeLayout) objArr[17], (LinearLayout) objArr[13], (LinearLayout) objArr[9], (TextView) objArr[14], (FrameLayout) objArr[4], (ImageView) objArr[16], (RobotoTextView) objArr[15], (ImageView) objArr[23], (RobotoTextView) objArr[24], (RobotoTextView) objArr[26], (LinearLayout) objArr[25], (TextView) objArr[10], (FrameLayout) objArr[2], (ImageView) objArr[12], (RobotoTextView) objArr[11], (RobotoTextView) objArr[28]);
        this.awW = -1;
        this.bQM.setTag(null);
        this.bQQ.setTag(null);
        this.bQS.setTag(null);
        this.bQW.setTag(null);
        this.bRd.setTag(null);
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
            a.a(this.bQM, voidR);
            a.a(this.bQQ, voidR);
            a.d(this.bQW, 0.5f);
            a.d(this.bRd, 0.5f);
        }
    }
}
