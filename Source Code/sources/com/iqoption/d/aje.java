package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: SignalItemBinding */
public abstract class aje extends ViewDataBinding {
    @NonNull
    public final TextView aiq;
    @NonNull
    public final TextView axH;
    @NonNull
    public final ImageView bTr;
    @NonNull
    public final ImageView bmu;
    @NonNull
    public final TextView bnB;
    @NonNull
    public final TextView bns;

    protected aje(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.axH = textView;
        this.bmu = imageView;
        this.bTr = imageView2;
        this.aiq = textView2;
        this.bnB = textView3;
        this.bns = textView4;
    }
}
