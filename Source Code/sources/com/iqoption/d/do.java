package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ChatItemBinding */
public abstract class do extends ViewDataBinding {
    @NonNull
    public final ImageView aEt;
    @NonNull
    public final TextView aEu;
    @NonNull
    public final TextView aEv;
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView bmM;
    @NonNull
    public final LinearLayout bmN;

    protected do(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.aEt = imageView;
        this.aEu = textView;
        this.aEv = textView2;
        this.bmM = imageView2;
        this.agA = textView3;
        this.bmN = linearLayout;
    }
}
