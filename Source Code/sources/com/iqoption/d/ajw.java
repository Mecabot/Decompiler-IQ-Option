package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: StringBasketItemBinding */
public abstract class ajw extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final ImageView biB;
    @NonNull
    public final ImageView biC;
    @NonNull
    public final ImageView biE;

    protected ajw(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3) {
        super(dataBindingComponent, view, i);
        this.avm = linearLayout;
        this.biB = imageView;
        this.aig = textView;
        this.biC = imageView2;
        this.biE = imageView3;
    }
}
