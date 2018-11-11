package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ItemPaymentMethodOldBinding */
public abstract class wh extends ViewDataBinding {
    @NonNull
    public final LinearLayout bJs;
    @NonNull
    public final ImageView bJt;
    @NonNull
    public final TextView bJu;

    protected wh(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bJs = linearLayout;
        this.bJt = imageView;
        this.bJu = textView;
    }
}
