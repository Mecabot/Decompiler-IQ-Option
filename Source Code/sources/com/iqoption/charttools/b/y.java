package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: TemplatesFigureItemBinding */
public abstract class y extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final TextView axH;
    @NonNull
    public final ImageView axI;
    @NonNull
    public final ImageView axJ;
    @NonNull
    public final ImageView axK;
    @NonNull
    public final ConstraintLayout axL;

    protected y(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.axH = textView;
        this.axI = imageView;
        this.axJ = imageView2;
        this.axK = imageView3;
        this.axL = constraintLayout;
        this.aig = textView2;
    }
}
