package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: TemplateInstrumentItemBinding */
public abstract class ake extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final ImageView bTC;
    @NonNull
    public final ImageView bTD;
    @NonNull
    public final ImageView bTE;

    protected ake(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bTC = imageView;
        this.bTD = imageView2;
        this.bTE = imageView3;
        this.avm = linearLayout;
        this.aig = textView;
    }
}
