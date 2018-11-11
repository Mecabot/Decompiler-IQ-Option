package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: ChatUserFileMessageItemBinding */
public abstract class ey extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final TextView aiq;

    protected ey(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.aig = textView;
        this.aiq = textView2;
    }
}
