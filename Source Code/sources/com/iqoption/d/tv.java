package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentVipChooseTimeBinding */
public abstract class tv extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView bFQ;
    @NonNull
    public final FrameLayout bFR;
    @NonNull
    public final TextView bFS;
    @NonNull
    public final LinearLayout bFT;
    @NonNull
    public final RecyclerView bFU;
    @NonNull
    public final TextView bFV;
    @NonNull
    public final RecyclerView bFW;
    @NonNull
    public final TextView bFX;
    @NonNull
    public final RecyclerView bFY;
    @NonNull
    public final TextView bFZ;
    @NonNull
    public final ImageView blw;

    protected tv(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, TextView textView2, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView3, RecyclerView recyclerView2, TextView textView4, TextView textView5, RecyclerView recyclerView3, TextView textView6) {
        super(dataBindingComponent, view, i);
        this.bFQ = textView;
        this.bFR = frameLayout;
        this.bFS = textView2;
        this.blw = imageView;
        this.bFT = linearLayout;
        this.bFU = recyclerView;
        this.bFV = textView3;
        this.bFW = recyclerView2;
        this.bFX = textView4;
        this.agA = textView5;
        this.bFY = recyclerView3;
        this.bFZ = textView6;
    }
}
