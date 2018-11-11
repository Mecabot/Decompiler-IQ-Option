package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.view.spinner.AwesomeTextSpinner;
import com.iqoption.x.R;

/* compiled from: PersonalInfoPageBindingImpl */
public class adj extends adi {
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
        awV.put(R.id.nameEdit, 2);
        awV.put(R.id.surnameEdit, 3);
        awV.put(R.id.tin, 4);
        awV.put(R.id.personalEmail, 5);
        awV.put(R.id.countrySpinner, 6);
        awV.put(R.id.countryCode, 7);
        awV.put(R.id.phone, 8);
        awV.put(R.id.iconAlertConfirm, 9);
        awV.put(R.id.confirmLink, 10);
        awV.put(R.id.genderLayout, 11);
        awV.put(R.id.male, 12);
        awV.put(R.id.maleCheck, 13);
        awV.put(R.id.female, 14);
        awV.put(R.id.femaleCheck, 15);
        awV.put(R.id.city, 16);
        awV.put(R.id.zip, 17);
        awV.put(R.id.address, 18);
        awV.put(R.id.deleteContainer, 19);
    }

    public adj(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, awU, awV));
    }

    private adj(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[18], (EditText) objArr[16], (TextView) objArr[10], (EditText) objArr[7], (AwesomeTextSpinner) objArr[6], (TextView) objArr[1], (LinearLayout) objArr[19], (LinearLayout) objArr[14], (ImageView) objArr[15], (FrameLayout) objArr[11], (ImageView) objArr[9], (LinearLayout) objArr[12], (ImageView) objArr[13], (EditText) objArr[2], (EditText) objArr[5], (ScrollView) objArr[0], (EditText) objArr[8], (EditText) objArr[3], (EditText) objArr[4], (EditText) objArr[17]);
        this.awW = -1;
        this.bOw.setTag(null);
        this.bOG.setTag(null);
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
            a.a(this.bOw, (Void) null);
        }
    }
}
