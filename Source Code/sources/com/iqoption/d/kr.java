package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: FeedBottomPanelBinding */
public abstract class kr extends ViewDataBinding {
    @NonNull
    public final LinearLayout bvE;
    @NonNull
    public final Space bvF;
    @NonNull
    public final TextView bvG;
    @NonNull
    public final LottieAnimationView bvH;
    @NonNull
    public final TextView bvI;
    @NonNull
    public final TextView bvJ;
    @NonNull
    public final TextView bvK;

    protected kr(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, Space space, TextView textView, LottieAnimationView lottieAnimationView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bvE = linearLayout;
        this.bvF = space;
        this.bvG = textView;
        this.bvH = lottieAnimationView;
        this.bvI = textView2;
        this.bvJ = textView3;
        this.bvK = textView4;
    }
}
