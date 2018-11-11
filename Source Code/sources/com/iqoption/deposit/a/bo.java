package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: LayoutDepositProtectedBinding */
public abstract class bo extends ViewDataBinding {
    @NonNull
    public final ImageView bKd;
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

    protected bo(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, TextView textView2, TextView textView3, ImageView imageView4) {
        super(dataBindingComponent, view, i);
        this.bKd = imageView;
        this.cah = textView;
        this.cai = imageView2;
        this.bKj = imageView3;
        this.bKk = textView2;
        this.bKl = textView3;
        this.caj = imageView4;
    }
}
