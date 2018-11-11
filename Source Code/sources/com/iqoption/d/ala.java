package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: VerifyCardItemBinding */
public abstract class ala extends ViewDataBinding {
    @NonNull
    public final TextView bFt;
    @NonNull
    public final ImageView bFv;
    @NonNull
    public final ImageView bTT;

    protected ala(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ImageView imageView2) {
        super(dataBindingComponent, view, i);
        this.bTT = imageView;
        this.bFt = textView;
        this.bFv = imageView2;
    }
}
