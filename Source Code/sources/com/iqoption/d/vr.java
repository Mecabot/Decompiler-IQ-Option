package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: IndicatorTitleItemBinding */
public abstract class vr extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final ImageView bIo;
    @NonNull
    public final ImageView bIp;
    @NonNull
    public final ImageView bmu;

    protected vr(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ImageView imageView3, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bIo = imageView;
        this.bIp = imageView2;
        this.avm = linearLayout;
        this.bmu = imageView3;
        this.agA = textView;
    }
}
