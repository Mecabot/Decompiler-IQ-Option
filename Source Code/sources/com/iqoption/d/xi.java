package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: LeftMenuItemBinding */
public abstract class xi extends ViewDataBinding {
    @NonNull
    public final TextView bKs;

    protected xi(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bKs = textView;
    }
}
