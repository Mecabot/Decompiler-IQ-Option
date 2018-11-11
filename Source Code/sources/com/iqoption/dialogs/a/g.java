package com.iqoption.dialogs.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: FragmentMenuListBinding */
public abstract class g extends ViewDataBinding {
    @NonNull
    public final RecyclerView ckU;

    protected g(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.ckU = recyclerView;
    }
}
