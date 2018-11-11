package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

/* compiled from: DepositOld3dsBinding */
public abstract class gi extends ViewDataBinding {
    @NonNull
    public final RelativeLayout bpa;
    @NonNull
    public final Switch bpb;
    @NonNull
    public final TextView bpc;
    @NonNull
    public final ImageView bpd;
    @NonNull
    public final ImageView bpe;
    @NonNull
    public final ImageView bpf;

    protected gi(DataBindingComponent dataBindingComponent, View view, int i, RelativeLayout relativeLayout, Switch switchR, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(dataBindingComponent, view, i);
        this.bpa = relativeLayout;
        this.bpb = switchR;
        this.bpc = textView;
        this.bpd = imageView;
        this.bpe = imageView2;
        this.bpf = imageView3;
    }
}
