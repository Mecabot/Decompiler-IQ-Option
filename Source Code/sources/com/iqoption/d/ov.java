package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/* compiled from: FragmentNewsAndUpdatesBinding */
public abstract class ov extends ViewDataBinding {
    @NonNull
    public final ImageView bwe;
    @NonNull
    public final RecyclerView bzh;

    protected ov(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bwe = imageView;
        this.bzh = recyclerView;
    }
}
