package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: StringBasketEmptyItemBinding */
public abstract class aju extends ViewDataBinding {
    @NonNull
    public final TextView aip;

    protected aju(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.aip = textView;
    }
}
