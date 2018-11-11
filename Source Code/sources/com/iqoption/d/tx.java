package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/* compiled from: FragmentVipEducationBinding */
public abstract class tx extends ViewDataBinding {
    @NonNull
    public final RecyclerView bFP;
    @NonNull
    public final ImageView blw;

    protected tx(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.blw = imageView;
        this.bFP = recyclerView;
    }
}
