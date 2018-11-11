package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

/* compiled from: ConstructorSpinnerFieldLightBinding */
public abstract class c extends ViewDataBinding {
    @NonNull
    public final EditText bYv;

    protected c(DataBindingComponent dataBindingComponent, View view, int i, EditText editText) {
        super(dataBindingComponent, view, i);
        this.bYv = editText;
    }
}
