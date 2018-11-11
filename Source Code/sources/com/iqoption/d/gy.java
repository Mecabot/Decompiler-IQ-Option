package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatSpinner2;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DepositPageCryptoBindingImpl */
public class gy extends gx {
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
        awV.put(R.id.cryptoLabel, 2);
        awV.put(R.id.depositToLabel, 3);
        awV.put(R.id.cryptoLayout, 4);
        awV.put(R.id.cryptoSpinner, 5);
        awV.put(R.id.paymentMethodCheck, 6);
        awV.put(R.id.yourCryptoAccount, 7);
        awV.put(R.id.qrLayout, 8);
        awV.put(R.id.qrCode, 9);
        awV.put(R.id.title, 10);
        awV.put(R.id.warning, 11);
        awV.put(R.id.instruction, 12);
    }

    public gy(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private gy(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RobotoTextView) objArr[1], (TextView) objArr[2], (FrameLayout) objArr[4], (AppCompatSpinner2) objArr[5], (TextView) objArr[3], (TextView) objArr[12], (ImageView) objArr[6], (ImageView) objArr[9], (LinearLayout) objArr[8], (TextView) objArr[10], (TextView) objArr[11], (RobotoTextView) objArr[7]);
        this.awW = -1;
        this.bqu.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            a.f(this.bqu, this.bqu.getResources().getDimension(R.dimen._dp4));
        }
    }
}
