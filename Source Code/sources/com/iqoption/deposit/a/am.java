package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ItemCurrencyLightBinding */
public abstract class am extends ViewDataBinding {
    @NonNull
    public final TextView bJk;
    @NonNull
    public final ImageView bZE;
    @NonNull
    public final LinearLayout bZF;
    @NonNull
    public final TextView bZG;

    protected am(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bZE = imageView;
        this.bZF = linearLayout;
        this.bJk = textView;
        this.bZG = textView2;
    }
}
