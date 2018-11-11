package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentVideoEducationCategoriesBinding */
public abstract class tn extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final Guideline awT;
    @NonNull
    public final RecyclerView bFF;

    protected tn(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView, TextView textView, Guideline guideline) {
        super(dataBindingComponent, view, i);
        this.bFF = recyclerView;
        this.agA = textView;
        this.awT = guideline;
    }
}
