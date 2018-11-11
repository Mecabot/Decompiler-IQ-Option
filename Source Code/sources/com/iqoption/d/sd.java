package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentSearchCountryBinding */
public abstract class sd extends ViewDataBinding {
    @NonNull
    public final View bBT;
    @NonNull
    public final LinearLayout bBU;
    @NonNull
    public final TextInputEditText bBV;
    @NonNull
    public final TextInputLayout bBW;
    @NonNull
    public final FrameLayout bBX;
    @NonNull
    public final ImageView bBY;
    @NonNull
    public final RecyclerView bBZ;
    @NonNull
    public final ImageView byW;
    @NonNull
    public final TextView byX;
    @NonNull
    public final LinearLayout byY;

    protected sd(DataBindingComponent dataBindingComponent, View view, int i, View view2, LinearLayout linearLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout, FrameLayout frameLayout, ImageView imageView, RecyclerView recyclerView, ImageView imageView2, TextView textView, LinearLayout linearLayout2) {
        super(dataBindingComponent, view, i);
        this.bBT = view2;
        this.bBU = linearLayout;
        this.bBV = textInputEditText;
        this.bBW = textInputLayout;
        this.bBX = frameLayout;
        this.bBY = imageView;
        this.bBZ = recyclerView;
        this.byW = imageView2;
        this.byX = textView;
        this.byY = linearLayout2;
    }
}
