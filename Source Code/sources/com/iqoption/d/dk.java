package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ChatImageMessageHeadItemBinding */
public abstract class dk extends ViewDataBinding {
    @NonNull
    public final TextView aiq;
    @NonNull
    public final ImageView blY;
    @NonNull
    public final TextView bmr;
    @NonNull
    public final LinearLayout bms;

    protected dk(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, ImageView imageView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bmr = textView;
        this.bms = linearLayout;
        this.blY = imageView;
        this.aiq = textView2;
    }
}
