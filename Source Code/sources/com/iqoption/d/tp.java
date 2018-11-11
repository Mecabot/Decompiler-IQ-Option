package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentVideoEducationSearchedVideosBinding */
public abstract class tp extends ViewDataBinding {
    @NonNull
    public final ImageView awN;
    @NonNull
    public final Guideline awT;
    @NonNull
    public final TextView bFG;
    @NonNull
    public final ConstraintLayout bFH;
    @NonNull
    public final RecyclerView bFI;
    @NonNull
    public final TextView bmq;

    protected tp(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout, Guideline guideline, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.awN = imageView;
        this.bFG = textView;
        this.bmq = textView2;
        this.bFH = constraintLayout;
        this.awT = guideline;
        this.bFI = recyclerView;
    }
}
