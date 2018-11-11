package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

/* compiled from: ConstructorTextEditFieldLightBinding */
public abstract class g extends ViewDataBinding {
    @NonNull
    public final EditText bYy;

    protected g(DataBindingComponent dataBindingComponent, View view, int i, EditText editText) {
        super(dataBindingComponent, view, i);
        this.bYy = editText;
    }
}
