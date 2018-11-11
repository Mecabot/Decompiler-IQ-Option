package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentIndicatorSettingsBinding */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView awM;
    @NonNull
    public final ImageView awN;
    @NonNull
    public final TextView awO;
    @NonNull
    public final Guideline awP;
    @NonNull
    public final View awQ;
    @NonNull
    public final RecyclerView awR;
    @Nullable
    public final FrameLayout awS;
    @Nullable
    public final Guideline awT;

    protected a(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, Guideline guideline, View view2, RecyclerView recyclerView, FrameLayout frameLayout, TextView textView3, Guideline guideline2) {
        super(dataBindingComponent, view, i);
        this.awM = textView;
        this.awN = imageView;
        this.awO = textView2;
        this.awP = guideline;
        this.awQ = view2;
        this.awR = recyclerView;
        this.awS = frameLayout;
        this.agA = textView3;
        this.awT = guideline2;
    }
}
