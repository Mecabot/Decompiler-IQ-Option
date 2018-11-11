package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner2;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.fragment.cashbox.AmountFrameViewSwitcher;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;

/* compiled from: DepositOldAmountLineBindingImpl */
public class gl extends gk {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ConstraintLayout biA;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.amountTextView, 1);
        awV.put(R.id.depositAmountEditTextFrame, 2);
        awV.put(R.id.amountFrameSwitcher, 3);
        awV.put(R.id.depositAmountEditText, 4);
        awV.put(R.id.depositAmountVipIcon, 5);
        awV.put(R.id.depositButtonSmall, 6);
        awV.put(R.id.currencySpinner, 7);
        awV.put(R.id.currencyTextView, 8);
        awV.put(R.id.currencyCheck, 9);
    }

    public gl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, awU, awV));
    }

    private gl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AmountFrameViewSwitcher) objArr[3], (TextView) objArr[1], (ImageView) objArr[9], (AppCompatSpinner2) objArr[7], (TextView) objArr[8], (EditText) objArr[4], (FrameLayout) objArr[2], (AppCompatImageView) objArr[5], (ConfirmButtonView) objArr[6]);
        this.awW = -1;
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
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
