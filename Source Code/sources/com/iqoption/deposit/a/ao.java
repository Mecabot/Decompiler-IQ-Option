package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ItemPaymentMethodBinding */
public abstract class ao extends ViewDataBinding {
    @NonNull
    public final LinearLayout bJs;
    @NonNull
    public final ImageView bJt;
    @NonNull
    public final TextView bJu;
    @NonNull
    public final ImageView bZH;
    @NonNull
    public final ImageView bZI;

    protected ao(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ImageView imageView3, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bZH = imageView;
        this.bZI = imageView2;
        this.bJs = linearLayout;
        this.bJt = imageView3;
        this.bJu = textView;
    }
}
