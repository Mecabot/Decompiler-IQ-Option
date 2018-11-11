package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: ToolsContentTemplatesBinding */
public abstract class aks extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final RecyclerView bTK;
    @NonNull
    public final ConstraintLayout bTL;
    @NonNull
    public final TextView bTN;

    protected aks(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, RecyclerView recyclerView, TextView textView2, ConstraintLayout constraintLayout) {
        super(dataBindingComponent, view, i);
        this.bTN = textView;
        this.bTK = recyclerView;
        this.agA = textView2;
        this.bTL = constraintLayout;
    }
}
