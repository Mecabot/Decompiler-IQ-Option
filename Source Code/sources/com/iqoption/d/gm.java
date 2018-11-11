package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: DepositPageAmountItemBinding */
public abstract class gm extends ViewDataBinding {
    @NonNull
    public final TextView bph;
    @NonNull
    public final View bpp;
    @NonNull
    public final ImageView bpq;
    @NonNull
    public final AppCompatImageView bpr;

    protected gm(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, View view2, ImageView imageView, AppCompatImageView appCompatImageView) {
        super(dataBindingComponent, view, i);
        this.bph = textView;
        this.bpp = view2;
        this.bpq = imageView;
        this.bpr = appCompatImageView;
    }
}
