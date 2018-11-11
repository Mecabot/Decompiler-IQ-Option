package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: MacroSmartFeedBinding */
public abstract class ys extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView awN;
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final RecyclerView bKX;

    protected ys(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.awN = imageView;
        this.axL = constraintLayout;
        this.bKX = recyclerView;
        this.agA = textView;
    }
}
