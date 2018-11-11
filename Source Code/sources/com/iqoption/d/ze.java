package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: MicroFeedTitleBinding */
public abstract class ze extends ViewDataBinding {
    @NonNull
    public final TextView bKW;
    @NonNull
    public final ConstraintLayout bLn;
    @NonNull
    public final ImageView bvP;
    @NonNull
    public final ImageView bvQ;

    protected ze(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, ConstraintLayout constraintLayout) {
        super(dataBindingComponent, view, i);
        this.bvP = imageView;
        this.bvQ = imageView2;
        this.bKW = textView;
        this.bLn = constraintLayout;
    }
}
