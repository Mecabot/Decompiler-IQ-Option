package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: SessionOtherItemBinding */
public abstract class aja extends ViewDataBinding {
    @NonNull
    public final TextView aiF;
    @NonNull
    public final TextView bTm;
    @NonNull
    public final TextView bTn;
    @NonNull
    public final TextView bTp;
    @NonNull
    public final ImageView bTq;
    @NonNull
    public final ImageView bmu;

    protected aja(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3, ImageView imageView2, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.aiF = textView;
        this.bmu = imageView;
        this.bTm = textView2;
        this.bTn = textView3;
        this.bTq = imageView2;
        this.bTp = textView4;
    }
}
