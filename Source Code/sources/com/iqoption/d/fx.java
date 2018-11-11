package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner2;
import android.support.v7.widget.CardView2;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: DepositCardFrontSideBindingImpl */
public class fx extends fw {
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
        awV.put(R.id.guidelineVerticalLeft, 1);
        awV.put(R.id.cardNumberTextView, 2);
        awV.put(R.id.expiryDateTextView, 3);
        awV.put(R.id.monthSpinner, 4);
        awV.put(R.id.monthCheck, 5);
        awV.put(R.id.monthDefault, 6);
        awV.put(R.id.yearSpinner, 7);
        awV.put(R.id.yearCheck, 8);
        awV.put(R.id.yearDefault, 9);
        awV.put(R.id.cardHolderNameTextView, 10);
        awV.put(R.id.visaIcon, 11);
        awV.put(R.id.masterCardIcon, 12);
        awV.put(R.id.cardHolderName, 13);
        awV.put(R.id.cardHolderNameDefault, 14);
        awV.put(R.id.cn, 15);
        awV.put(R.id.cnDefault, 16);
    }

    public fx(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, awU, awV));
    }

    private fx(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[13], (TextView) objArr[14], (TextView) objArr[10], (TextView) objArr[2], (EditText) objArr[15], (TextView) objArr[16], (TextView) objArr[3], (CardView2) objArr[0], (View) objArr[1], (ImageView) objArr[12], (ImageView) objArr[5], (TextView) objArr[6], (AppCompatSpinner2) objArr[4], (ImageView) objArr[11], (ImageView) objArr[8], (TextView) objArr[9], (AppCompatSpinner2) objArr[7]);
        this.awW = -1;
        this.bou.setTag(null);
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
