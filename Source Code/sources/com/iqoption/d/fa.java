package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ChatUserImageMessageItemBinding */
public abstract class fa extends ViewDataBinding {
    @NonNull
    public final TextView aiq;
    @NonNull
    public final ImageView blY;

    protected fa(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.blY = imageView;
        this.aiq = textView;
    }
}
