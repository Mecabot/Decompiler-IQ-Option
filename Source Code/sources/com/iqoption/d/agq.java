package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: PriceMovementsFragmentBinding */
public abstract class agq extends ViewDataBinding {
    @NonNull
    public final Guideline awT;
    @NonNull
    public final TextView bQb;
    @NonNull
    public final RecyclerView bQc;
    @NonNull
    public final TextView bQd;
    @NonNull
    public final LinearLayout bzE;

    protected agq(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, TextView textView, RecyclerView recyclerView, TextView textView2, Guideline guideline) {
        super(dataBindingComponent, view, i);
        this.bzE = linearLayout;
        this.bQb = textView;
        this.bQc = recyclerView;
        this.bQd = textView2;
        this.awT = guideline;
    }
}
