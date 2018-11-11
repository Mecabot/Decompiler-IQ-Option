package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: PortfolioFilterOptionsBinding */
public abstract class aez extends ViewDataBinding {
    @NonNull
    public final RecyclerView axw;

    protected aez(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.axw = recyclerView;
    }
}
