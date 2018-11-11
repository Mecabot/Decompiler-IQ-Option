package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: MicroSmartFeedBinding */
public abstract class abe extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final Guideline awT;
    @NonNull
    public final ImageView axz;
    @NonNull
    public final RecyclerView bKX;

    protected abe(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RecyclerView recyclerView, TextView textView, Guideline guideline) {
        super(dataBindingComponent, view, i);
        this.axz = imageView;
        this.bKX = recyclerView;
        this.agA = textView;
        this.awT = guideline;
    }
}
