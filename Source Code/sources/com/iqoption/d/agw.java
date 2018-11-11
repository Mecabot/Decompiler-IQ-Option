package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: PriceMovementsItemBinding */
public abstract class agw extends ViewDataBinding {
    @NonNull
    public final TextView bHW;
    @NonNull
    public final TextView bHY;
    @NonNull
    public final TextView bQh;
    @NonNull
    public final ImageView bQi;
    @NonNull
    public final LinearLayout bQj;
    @NonNull
    public final ImageView bQk;
    @NonNull
    public final ImageView bQl;
    @NonNull
    public final ImageView bQm;
    @NonNull
    public final TextView bQn;
    @NonNull
    public final TextView bQo;

    protected agw(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.bHW = textView;
        this.bQh = textView2;
        this.bQi = imageView;
        this.bQj = linearLayout;
        this.bQk = imageView2;
        this.bQl = imageView3;
        this.bQm = imageView4;
        this.bQn = textView3;
        this.bQo = textView4;
        this.bHY = textView5;
    }
}
