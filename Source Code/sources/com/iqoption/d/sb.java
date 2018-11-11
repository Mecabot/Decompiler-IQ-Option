package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: FragmentRoomListBinding */
public abstract class sb extends ViewDataBinding {
    @NonNull
    public final RecyclerView bzb;

    protected sb(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bzb = recyclerView;
    }
}
