package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: DepositPaymentMethodItemBinding */
public abstract class hf extends ViewDataBinding {
    @NonNull
    public final TextView boX;
    @NonNull
    public final ImageView bqS;
    @NonNull
    public final ImageView bqT;

    protected hf(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bqS = imageView;
        this.bqT = imageView2;
        this.boX = textView;
    }
}
