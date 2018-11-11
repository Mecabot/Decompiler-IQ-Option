package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ChatFileMessageTailItemBinding */
public abstract class cq extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final TextView aiq;
    @NonNull
    public final ImageView bmj;

    protected cq(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bmj = imageView;
        this.aig = textView;
        this.aiq = textView2;
    }
}
