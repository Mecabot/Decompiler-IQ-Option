package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ChatImageMessageTailItemBinding */
public abstract class dm extends ViewDataBinding {
    @NonNull
    public final TextView aiq;
    @NonNull
    public final ImageView blY;
    @NonNull
    public final ImageView bmj;

    protected dm(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bmj = imageView;
        this.blY = imageView2;
        this.aiq = textView;
    }
}
