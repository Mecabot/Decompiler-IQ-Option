package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;

/* compiled from: ConstructorSpinnerFieldBinding */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final TextInputEditText bYt;
    @NonNull
    public final TextInputLayout bYu;

    protected a(DataBindingComponent dataBindingComponent, View view, int i, TextInputEditText textInputEditText, TextInputLayout textInputLayout) {
        super(dataBindingComponent, view, i);
        this.bYt = textInputEditText;
        this.bYu = textInputLayout;
    }
}
