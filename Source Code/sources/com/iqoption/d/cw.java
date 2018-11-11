package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: ChatFragmentAttachmentPickerBinding */
public abstract class cw extends ViewDataBinding {
    @NonNull
    public final LinearLayout bjl;
    @NonNull
    public final CoordinatorLayout bmA;
    @NonNull
    public final TextView bmv;
    @NonNull
    public final LinearLayout bmw;
    @NonNull
    public final LottieAnimationView bmx;
    @NonNull
    public final TextView bmy;
    @NonNull
    public final RecyclerView bmz;

    protected cw(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, LottieAnimationView lottieAnimationView, TextView textView2, RecyclerView recyclerView, CoordinatorLayout coordinatorLayout) {
        super(dataBindingComponent, view, i);
        this.bmv = textView;
        this.bmw = linearLayout;
        this.bjl = linearLayout2;
        this.bmx = lottieAnimationView;
        this.bmy = textView2;
        this.bmz = recyclerView;
        this.bmA = coordinatorLayout;
    }
}
