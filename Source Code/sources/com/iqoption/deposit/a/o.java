package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentDepositMethodsLightBinding */
public abstract class o extends ViewDataBinding {
    @NonNull
    public final TextView bYQ;
    @NonNull
    public final FrameLayout bYR;
    @NonNull
    public final LinearLayout bYT;
    @NonNull
    public final TextView bYU;
    @NonNull
    public final ImageView bYV;
    @NonNull
    public final RecyclerView bxp;

    protected o(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView2, FrameLayout frameLayout, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bYQ = textView;
        this.bYT = linearLayout;
        this.bxp = recyclerView;
        this.bYU = textView2;
        this.bYR = frameLayout;
        this.bYV = imageView;
    }
}
