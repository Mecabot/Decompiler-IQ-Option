package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: ItemCurrencySelectionBinding */
public abstract class wb extends ViewDataBinding {
    @NonNull
    public final TextView bJk;

    protected wb(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bJk = textView;
    }
}
