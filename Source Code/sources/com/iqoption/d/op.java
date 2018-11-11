package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentMicroRoomListBinding */
public abstract class op extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final Guideline awT;
    @NonNull
    public final ImageView axz;
    @NonNull
    public final RecyclerView bzb;

    protected op(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RecyclerView recyclerView, TextView textView, Guideline guideline) {
        super(dataBindingComponent, view, i);
        this.axz = imageView;
        this.bzb = recyclerView;
        this.agA = textView;
        this.awT = guideline;
    }
}
