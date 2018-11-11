package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Barrier;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentProTraderActiveBinding */
public abstract class qd extends ViewDataBinding {
    @NonNull
    public final TextView bAA;
    @NonNull
    public final TextView bAB;
    @NonNull
    public final ImageView bAw;
    @NonNull
    public final Barrier bAx;
    @NonNull
    public final ImageView bAy;
    @NonNull
    public final ConstraintLayout bAz;

    protected qd(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, Barrier barrier, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bAw = imageView;
        this.bAx = barrier;
        this.bAy = imageView2;
        this.bAz = constraintLayout;
        this.bAA = textView;
        this.bAB = textView2;
    }
}
