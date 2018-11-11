package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentQuizInsightsItemBinding */
public abstract class qv extends ViewDataBinding {
    @NonNull
    public final TextView afV;
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final TextView axy;
    @NonNull
    public final TextView bAV;
    @NonNull
    public final TextView bAW;
    @NonNull
    public final TextView bAX;
    @NonNull
    public final ImageView bmu;

    protected qv(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ConstraintLayout constraintLayout, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.afV = textView;
        this.axL = constraintLayout;
        this.axy = textView2;
        this.bmu = imageView;
        this.bAV = textView3;
        this.bAW = textView4;
        this.bAX = textView5;
    }
}
