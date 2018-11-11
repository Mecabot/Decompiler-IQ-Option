package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentQuizInsightsDelegateBinding */
public abstract class qt extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final RecyclerView axw;

    protected qt(DataBindingComponent dataBindingComponent, View view, int i, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.axL = constraintLayout;
        this.axw = recyclerView;
        this.agA = textView;
    }
}
