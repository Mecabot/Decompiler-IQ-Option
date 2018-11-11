package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: PortfolioMicroFilterItemBinding */
public abstract class afd extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView bmu;

    protected afd(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bmu = imageView;
        this.agA = textView;
    }
}
