package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/* compiled from: FragmentVipAboutBinding */
public abstract class tt extends ViewDataBinding {
    @NonNull
    public final ImageView bFO;
    @NonNull
    public final RecyclerView bFP;
    @NonNull
    public final ImageView blw;

    protected tt(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bFO = imageView;
        this.blw = imageView2;
        this.bFP = recyclerView;
    }
}
