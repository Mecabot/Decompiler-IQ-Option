package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: LeftMenuItemListBinding */
public abstract class xu extends ViewDataBinding {
    @NonNull
    public final RecyclerView axw;
    @NonNull
    public final FrameLayout bKy;

    protected xu(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bKy = frameLayout;
        this.axw = recyclerView;
    }
}
