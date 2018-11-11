package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: ToolsContentActiveToolsBinding */
public abstract class akm extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView bTI;
    @NonNull
    public final TextView bTJ;
    @NonNull
    public final RecyclerView bTK;
    @NonNull
    public final ConstraintLayout bTL;
    @NonNull
    public final TextView blE;
    @NonNull
    public final TextView brN;

    protected akm(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView, TextView textView5, ConstraintLayout constraintLayout) {
        super(dataBindingComponent, view, i);
        this.blE = textView;
        this.bTI = textView2;
        this.brN = textView3;
        this.bTJ = textView4;
        this.bTK = recyclerView;
        this.agA = textView5;
        this.bTL = constraintLayout;
    }
}
