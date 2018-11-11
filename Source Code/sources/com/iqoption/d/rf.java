package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentQuizLeaderboardYouItemBinding */
public abstract class rf extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final ImageView bBc;
    @NonNull
    public final TextView bBd;
    @NonNull
    public final TextView bBe;
    @NonNull
    public final TextView bBf;

    protected rf(DataBindingComponent dataBindingComponent, View view, int i, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.axL = constraintLayout;
        this.aig = textView;
        this.bBc = imageView;
        this.bBd = textView2;
        this.bBe = textView3;
        this.bBf = textView4;
    }
}
