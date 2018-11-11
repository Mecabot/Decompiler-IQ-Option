package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: MicroBottomPanelBinding */
public abstract class zc extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout bLl;
    @NonNull
    public final TextView bLm;
    @NonNull
    public final TextView bvG;
    @NonNull
    public final LottieAnimationView bvH;
    @NonNull
    public final TextView bvJ;
    @NonNull
    public final TextView bvK;

    protected zc(DataBindingComponent dataBindingComponent, View view, int i, ConstraintLayout constraintLayout, TextView textView, LottieAnimationView lottieAnimationView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bLl = constraintLayout;
        this.bvG = textView;
        this.bvH = lottieAnimationView;
        this.bLm = textView2;
        this.bvJ = textView3;
        this.bvK = textView4;
    }
}
