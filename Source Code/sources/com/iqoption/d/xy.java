package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: LeftMenuItemProTraderBinding */
public abstract class xy extends ViewDataBinding {
    @NonNull
    public final LinearLayout bKA;
    @NonNull
    public final ImageView bKB;
    @NonNull
    public final TextView bKC;
    @NonNull
    public final TextView bKD;
    @NonNull
    public final ImageView bKz;

    protected xy(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bKz = imageView;
        this.bKA = linearLayout;
        this.bKB = imageView2;
        this.bKC = textView;
        this.bKD = textView2;
    }
}
