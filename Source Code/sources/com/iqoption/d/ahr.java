package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateCfdOnOpenConfirmationBindingImpl */
public class ahr extends ahq {
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
        awV.put(R.id.investValue, 7);
        awV.put(R.id.textView2, 8);
        awV.put(R.id.multValue, 9);
        awV.put(R.id.overnightContainer, 10);
        awV.put(R.id.overnightTitle, 11);
        awV.put(R.id.overnightValue, 12);
        awV.put(R.id.insidePendingLayout, 13);
        awV.put(R.id.pendingLabel, 14);
        awV.put(R.id.pendingValue, 15);
        awV.put(R.id.pendingPicker, 16);
        awV.put(R.id.insideLimitsLayout, 17);
        awV.put(R.id.limitsLabel, 18);
        awV.put(R.id.limitsValue, 19);
        awV.put(R.id.limitsPicker, 20);
        awV.put(R.id.btnConfirmLayout, 21);
        awV.put(R.id.totalInvest, 22);
        awV.put(R.id.btnConfirm, 23);
    }

    public ahr(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 24, awU, awV));
    }

    private ahr(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (RobotoTextView) objArr[23], (LinearLayout) objArr[21], (ImageView) objArr[6], (ImageView) objArr[3], (RobotoTextView) objArr[5], (LinearLayout) objArr[0], (LinearLayout) objArr[17], (LinearLayout) objArr[13], (RobotoTextView) objArr[7], (TextView) objArr[18], (FrameLayout) objArr[4], (ImageView) objArr[20], (RobotoTextView) objArr[19], (RobotoTextView) objArr[9], (ConstraintLayout) objArr[10], (RobotoTextView) objArr[11], (RobotoTextView) objArr[12], (TextView) objArr[14], (FrameLayout) objArr[2], (ImageView) objArr[16], (RobotoTextView) objArr[15], (RobotoTextView) objArr[8], (RobotoTextView) objArr[22]);
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
