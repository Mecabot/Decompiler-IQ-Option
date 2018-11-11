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

/* compiled from: FragmentCommissionChangeBinding */
public abstract class lm extends ViewDataBinding {
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final TextView brN;
    @NonNull
    public final FrameLayout bxe;
    @NonNull
    public final LinearLayout bxf;
    @NonNull
    public final RecyclerView bxg;
    @NonNull
    public final ImageView bxh;
    @NonNull
    public final LinearLayout bxi;
    @NonNull
    public final TextView bxj;
    @NonNull
    public final TextView bxk;
    @NonNull
    public final TextView bxl;

    protected lm(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, RecyclerView recyclerView, FrameLayout frameLayout2, ImageView imageView, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bxe = frameLayout;
        this.brN = textView;
        this.bxf = linearLayout;
        this.bxg = recyclerView;
        this.blV = frameLayout2;
        this.bxh = imageView;
        this.bxi = linearLayout2;
        this.bxj = textView2;
        this.bxk = textView3;
        this.bxl = textView4;
    }
}
