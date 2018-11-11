package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: WithdrawInsufficientFoundsLayoutBinding */
public abstract class amr extends ViewDataBinding {
    @NonNull
    public final TextView bVa;
    @NonNull
    public final ImageView bVb;
    @NonNull
    public final TextView bVc;

    protected amr(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bVa = textView;
        this.bVb = imageView;
        this.bVc = textView2;
    }
}
