package com.iqoption.dialogs.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: FragmentMenuListLightBinding */
public abstract class i extends ViewDataBinding {
    @NonNull
    public final RecyclerView ckU;

    protected i(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.ckU = recyclerView;
    }
}
