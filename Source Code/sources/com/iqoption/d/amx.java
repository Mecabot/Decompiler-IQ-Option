package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: WithdrawVerifyButtonBinding */
public abstract class amx extends ViewDataBinding {
    @NonNull
    public final TextView bVg;
    @NonNull
    public final ImageView bVh;

    protected amx(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bVg = textView;
        this.bVh = imageView;
    }
}
