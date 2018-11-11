package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: LeftMenuItemCounterBinding */
public abstract class xq extends ViewDataBinding {
    @NonNull
    public final TextView bKs;
    @NonNull
    public final TextView bKv;

    protected xq(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bKv = textView;
        this.bKs = textView2;
    }
}
