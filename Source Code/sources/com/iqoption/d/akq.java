package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: ToolsContentSettingsBinding */
public abstract class akq extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final RecyclerView bTK;
    @NonNull
    public final ConstraintLayout bTL;

    protected akq(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView, TextView textView, ConstraintLayout constraintLayout) {
        super(dataBindingComponent, view, i);
        this.bTK = recyclerView;
        this.agA = textView;
        this.bTL = constraintLayout;
    }
}
