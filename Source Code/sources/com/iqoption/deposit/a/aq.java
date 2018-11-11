package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ItemPaymentMethodLightBinding */
public abstract class aq extends ViewDataBinding {
    @NonNull
    public final LinearLayout bJs;
    @NonNull
    public final ImageView bJt;
    @NonNull
    public final TextView bJu;
    @NonNull
    public final View bZJ;
    @NonNull
    public final TextView bZK;

    protected aq(DataBindingComponent dataBindingComponent, View view, int i, View view2, LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bZJ = view2;
        this.bJs = linearLayout;
        this.bZK = textView;
        this.bJt = imageView;
        this.bJu = textView2;
    }
}
