package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: LayoutDepositProtectedLightBinding */
public abstract class bq extends ViewDataBinding {
    @NonNull
    public final ImageView bKd;
    @NonNull
    public final ImageView bKf;
    @NonNull
    public final ImageView bKj;
    @NonNull
    public final TextView bKk;
    @NonNull
    public final TextView bKl;
    @NonNull
    public final TextView cah;
    @NonNull
    public final ImageView cai;
    @NonNull
    public final ImageView caj;
    @NonNull
    public final TextView cak;

    protected bq(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, ImageView imageView3, ImageView imageView4, TextView textView3, TextView textView4, ImageView imageView5) {
        super(dataBindingComponent, view, i);
        this.bKd = imageView;
        this.cah = textView;
        this.bKf = imageView2;
        this.cak = textView2;
        this.cai = imageView3;
        this.bKj = imageView4;
        this.bKk = textView3;
        this.bKl = textView4;
        this.caj = imageView5;
    }
}
