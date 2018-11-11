package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: DepositPaymentUnsuccessfulCompletedBinding */
public abstract class hj extends ViewDataBinding {
    @NonNull
    public final TextView bqW;
    @NonNull
    public final ImageView bqX;
    @NonNull
    public final TextView bqY;
    @NonNull
    public final TextView bqZ;

    protected hj(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bqW = textView;
        this.bqX = imageView;
        this.bqY = textView2;
        this.bqZ = textView3;
    }
}
