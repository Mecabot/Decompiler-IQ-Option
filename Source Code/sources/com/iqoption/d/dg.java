package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ChatImageMessageBodyItemBinding */
public abstract class dg extends ViewDataBinding {
    @NonNull
    public final TextView aiq;
    @NonNull
    public final ImageView blY;

    protected dg(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.blY = imageView;
        this.aiq = textView;
    }
}
