package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: OtnLeaderBoardCurrentUserItemBinding */
public abstract class acu extends ViewDataBinding {
    @NonNull
    public final ImageView bzA;
    @NonNull
    public final TextView bzJ;
    @NonNull
    public final TextView bzN;
    @NonNull
    public final TextView bzO;
    @NonNull
    public final TextView bzP;

    protected acu(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bzA = imageView;
        this.bzJ = textView;
        this.bzN = textView2;
        this.bzO = textView3;
        this.bzP = textView4;
    }
}
