package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: DialogProTraderSelectedBinding */
public abstract class jl extends ViewDataBinding {
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final TextView btA;
    @NonNull
    public final ImageView btB;
    @NonNull
    public final FrameLayout btC;
    @NonNull
    public final TextView btD;
    @NonNull
    public final TextView btE;

    protected jl(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, ImageView imageView, FrameLayout frameLayout2, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bjF = frameLayout;
        this.btA = textView;
        this.btB = imageView;
        this.btC = frameLayout2;
        this.btD = textView2;
        this.btE = textView3;
    }
}
