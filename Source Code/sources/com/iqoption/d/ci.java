package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: ChatEmptyItemBinding */
public abstract class ci extends ViewDataBinding {
    @NonNull
    public final TextView bmq;

    protected ci(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bmq = textView;
    }
}
