package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: IndicatorConstructorGroupTitleItemBinding */
public abstract class k extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final ImageView axz;

    protected k(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.axz = imageView;
        this.avm = linearLayout;
        this.agA = textView;
    }
}
