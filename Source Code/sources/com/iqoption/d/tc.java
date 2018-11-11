package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: FragmentTrialRegistrationBindingImpl */
public class tc extends tb {
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
        awV.put(R.id.registerContainer, 6);
        awV.put(R.id.title, 7);
        awV.put(R.id.registrationClose, 8);
        awV.put(R.id.registerContentContainer, 9);
        awV.put(R.id.emailLayout, 10);
        awV.put(R.id.emailEdit, 11);
        awV.put(R.id.passwordLayout, 12);
        awV.put(R.id.passwordEdit, 13);
        awV.put(R.id.countryContainer, 14);
        awV.put(R.id.countryInput, 15);
        awV.put(R.id.countryEdit, 16);
        awV.put(R.id.countryProgress, 17);
        awV.put(R.id.accountCurrencyLayout, 18);
        awV.put(R.id.accountCurrencyTitle, 19);
        awV.put(R.id.currencySpinnerTitle, 20);
        awV.put(R.id.ageLayout, 21);
        awV.put(R.id.checkBoxAge, 22);
        awV.put(R.id.ageAgreeeText, 23);
        awV.put(R.id.welcomePolicyCheck, 24);
        awV.put(R.id.welcomePolicyText, 25);
        awV.put(R.id.button, 26);
        awV.put(R.id.registerOther, 27);
    }

    public tc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 28, awU, awV));
    }

    private tc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[18], (LinearLayout) objArr[4], (TextView) objArr[19], (TextView) objArr[23], (LinearLayout) objArr[21], (TextView) objArr[26], (CheckBox) objArr[22], (FrameLayout) objArr[14], (TextInputEditText) objArr[16], (TextInputLayout) objArr[15], (ImageView) objArr[2], (ImageView) objArr[3], (ContentLoadingProgressBar) objArr[17], (TextView) objArr[20], (TextInputEditText) objArr[11], (TextInputLayout) objArr[10], (FrameLayout) objArr[0], (TextInputEditText) objArr[13], (TextInputLayout) objArr[12], (ToggleButton) objArr[1], (ContentLoadingProgressBar) objArr[5], (FrameLayout) objArr[6], (FrameLayout) objArr[9], (FrameLayout) objArr[27], (ImageView) objArr[8], (TextView) objArr[7], (CheckBox) objArr[24], (TextView) objArr[25]);
        this.awW = -1;
        this.bEF.setTag(null);
        this.bBY.setTag(null);
        this.bEL.setTag(null);
        this.bjF.setTag(null);
        this.bER.setTag(null);
        this.bnn.setTag(null);
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
            a.d(this.bEF, 0.5f);
            a.d(this.bBY, 0.5f);
            a.d(this.bEL, 0.5f);
            a.d(this.bER, 0.5f);
            a.a(this.bnn, ViewDataBinding.getColorFromResource(this.bnn, R.color.white));
        }
    }
}
