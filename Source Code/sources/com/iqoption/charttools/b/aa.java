package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: TemplatesIndicatorItemBinding */
public abstract class aa extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final ImageView axI;
    @NonNull
    public final ImageView axJ;
    @NonNull
    public final ImageView axK;
    @NonNull
    public final ConstraintLayout axL;

    protected aa(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.axI = imageView;
        this.axJ = imageView2;
        this.axK = imageView3;
        this.axL = constraintLayout;
        this.aig = textView;
    }
}
