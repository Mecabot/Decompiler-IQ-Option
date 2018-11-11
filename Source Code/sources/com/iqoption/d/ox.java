package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.v4.widget.Space;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: FragmentOnboardinWelcomSlideBinding */
public abstract class ox extends ViewDataBinding {
    @NonNull
    public final LottieAnimationView bzi;
    @NonNull
    public final Guideline bzj;
    @NonNull
    public final Space bzk;
    @NonNull
    public final TextView bzl;
    @NonNull
    public final TextView bzm;

    protected ox(DataBindingComponent dataBindingComponent, View view, int i, LottieAnimationView lottieAnimationView, Guideline guideline, Space space, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bzi = lottieAnimationView;
        this.bzj = guideline;
        this.bzk = space;
        this.bzl = textView;
        this.bzm = textView2;
    }
}
