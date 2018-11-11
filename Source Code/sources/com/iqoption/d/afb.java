package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: PortfolioMacroFilterItemBinding */
public abstract class afb extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView bmu;
    @NonNull
    public final TextView bns;

    protected afb(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bmu = imageView;
        this.agA = textView;
        this.bns = textView2;
    }
}
