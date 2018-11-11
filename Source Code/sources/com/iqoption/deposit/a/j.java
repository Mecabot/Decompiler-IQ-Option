package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.deposit.r.f;

/* compiled from: FragmentCardPaymentBindingImpl */
public class j extends i {
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
        awV.put(f.cardNumberInput, 1);
        awV.put(f.cardNumber, 2);
        awV.put(f.cardType, 3);
        awV.put(f.scan_card, 4);
        awV.put(f.cardHolderInput, 5);
        awV.put(f.cardHolderName, 6);
        awV.put(f.cardMonthInput, 7);
        awV.put(f.month, 8);
        awV.put(f.cardYearInput, 9);
        awV.put(f.year, 10);
        awV.put(f.cardVnInput, 11);
        awV.put(f.vn, 12);
    }

    public j(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private j(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (TextInputLayout) objArr[5], (TextInputEditText) objArr[6], (TextInputLayout) objArr[7], (TextInputEditText) objArr[2], (TextInputLayout) objArr[1], (ImageView) objArr[3], (TextInputLayout) objArr[11], (TextInputLayout) objArr[9], (TextInputEditText) objArr[8], (ImageView) objArr[4], (TextInputEditText) objArr[12], (TextInputEditText) objArr[10]);
        this.awW = -1;
        this.bYz.setTag(null);
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
