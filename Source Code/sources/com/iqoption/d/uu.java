package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView2;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentWithdrawVerifyPageBinding */
public abstract class uu extends ViewDataBinding {
    @NonNull
    public final CardView2 bHs;
    @NonNull
    public final amx bHt;
    @NonNull
    public final amx bHu;
    @NonNull
    public final ImageView bHv;
    @NonNull
    public final TextView bHw;
    @NonNull
    public final TextView bHx;

    protected uu(DataBindingComponent dataBindingComponent, View view, int i, CardView2 cardView2, amx amx, amx amx2, ImageView imageView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bHs = cardView2;
        this.bHt = amx;
        setContainedBinding(this.bHt);
        this.bHu = amx2;
        setContainedBinding(this.bHu);
        this.bHv = imageView;
        this.bHw = textView;
        this.bHx = textView2;
    }
}
