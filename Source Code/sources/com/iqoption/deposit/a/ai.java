package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ItemConstructorSpinnerLightBinding */
public abstract class ai extends ViewDataBinding {
    @NonNull
    public final ImageView bZB;
    @NonNull
    public final LinearLayout bZC;
    @NonNull
    public final TextView bZD;

    protected ai(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bZB = imageView;
        this.bZC = linearLayout;
        this.bZD = textView;
    }
}
