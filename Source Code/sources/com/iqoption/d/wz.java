package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: LayoutProTraderBenefitsTopRowBinding */
public abstract class wz extends ViewDataBinding {
    @NonNull
    public final ImageView bKa;
    @NonNull
    public final TextView bKb;

    protected wz(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bKa = imageView;
        this.bKb = textView;
    }
}
