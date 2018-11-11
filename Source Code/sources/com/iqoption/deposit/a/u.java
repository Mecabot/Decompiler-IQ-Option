package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: FragmentPaymentCompletedBinding */
public abstract class u extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView bZm;
    @NonNull
    public final TextView bZn;
    @NonNull
    public final TextView bZo;
    @NonNull
    public final LinearLayout bZp;
    @NonNull
    public final TextView bZq;
    @NonNull
    public final ConstraintLayout bZr;
    @NonNull
    public final TextView bZs;
    @NonNull
    public final LottieAnimationView bZt;
    @NonNull
    public final TextView bZu;
    @NonNull
    public final TextView bZv;

    protected u(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, ConstraintLayout constraintLayout, TextView textView4, LottieAnimationView lottieAnimationView, TextView textView5, TextView textView6, TextView textView7) {
        super(dataBindingComponent, view, i);
        this.bZm = imageView;
        this.bZn = textView;
        this.bZo = textView2;
        this.bZp = linearLayout;
        this.bZq = textView3;
        this.bZr = constraintLayout;
        this.bZs = textView4;
        this.bZt = lottieAnimationView;
        this.bZu = textView5;
        this.bZv = textView6;
        this.agA = textView7;
    }
}
