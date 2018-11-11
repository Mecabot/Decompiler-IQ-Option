package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: SplashBinding */
public abstract class ajq extends ViewDataBinding {
    @NonNull
    public final ImageView bTu;
    @NonNull
    public final View bTv;
    @NonNull
    public final TextView bTw;
    @NonNull
    public final TextView bTx;
    @NonNull
    public final TextView bTy;
    @NonNull
    public final TextView bTz;
    @NonNull
    public final ImageView biO;

    protected ajq(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, View view2, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bTu = imageView;
        this.bTv = view2;
        this.bTw = textView;
        this.biO = imageView2;
        this.bTx = textView2;
        this.bTy = textView3;
        this.bTz = textView4;
    }
}
