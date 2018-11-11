package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;

/* compiled from: ConstructorTextEditFieldBinding */
public abstract class e extends ViewDataBinding {
    @NonNull
    public final TextInputEditText bYw;
    @NonNull
    public final TextInputLayout bYx;

    protected e(DataBindingComponent dataBindingComponent, View view, int i, TextInputEditText textInputEditText, TextInputLayout textInputLayout) {
        super(dataBindingComponent, view, i);
        this.bYw = textInputEditText;
        this.bYx = textInputLayout;
    }
}
