package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ItemScanCardLightBinding */
public abstract class bc extends ViewDataBinding {
    @NonNull
    public final LinearLayout bZQ;
    @NonNull
    public final ImageView bZR;
    @NonNull
    public final TextView bZS;

    protected bc(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bZQ = linearLayout;
        this.bZR = imageView;
        this.bZS = textView;
    }
}
