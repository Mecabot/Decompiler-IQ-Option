package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: VideoEducationSimpleCategoryItemBinding */
public abstract class alk extends ViewDataBinding {
    @NonNull
    public final ImageView aEt;
    @NonNull
    public final TextView agA;
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final TextView bUf;
    @NonNull
    public final TextView bUg;

    protected alk(DataBindingComponent dataBindingComponent, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.axL = constraintLayout;
        this.aEt = imageView;
        this.bUf = textView;
        this.agA = textView2;
        this.bUg = textView3;
    }
}
