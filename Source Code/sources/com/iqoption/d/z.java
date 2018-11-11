package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ActiveToolsItemBinding */
public abstract class z extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final ImageView biB;
    @NonNull
    public final ImageView biC;
    @NonNull
    public final TextView biD;
    @NonNull
    public final ImageView biE;

    protected z(DataBindingComponent dataBindingComponent, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, ImageView imageView3) {
        super(dataBindingComponent, view, i);
        this.axL = constraintLayout;
        this.biB = imageView;
        this.aig = textView;
        this.biC = imageView2;
        this.biD = textView2;
        this.biE = imageView3;
    }
}
