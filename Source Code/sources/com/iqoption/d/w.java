package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* compiled from: ActiveSessionsFragmentBinding */
public abstract class w extends ViewDataBinding {
    @NonNull
    public final View biw;
    @NonNull
    public final FrameLayout bix;
    @NonNull
    public final RecyclerView biy;
    @NonNull
    public final LinearLayout biz;

    protected w(DataBindingComponent dataBindingComponent, View view, int i, View view2, FrameLayout frameLayout, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.biw = view2;
        this.bix = frameLayout;
        this.biy = recyclerView;
        this.biz = linearLayout;
    }
}
