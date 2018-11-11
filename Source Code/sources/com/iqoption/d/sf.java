package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentSignalsBinding */
public abstract class sf extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView bAZ;
    @NonNull
    public final RecyclerView bCa;
    @NonNull
    public final Guideline bCb;

    protected sf(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, RecyclerView recyclerView, TextView textView2, Guideline guideline) {
        super(dataBindingComponent, view, i);
        this.bAZ = textView;
        this.bCa = recyclerView;
        this.agA = textView2;
        this.bCb = guideline;
    }
}
