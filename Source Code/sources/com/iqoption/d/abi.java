package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: MoreTradingOpportunitiesBinding */
public abstract class abi extends ViewDataBinding {
    @NonNull
    public final TextView bMj;
    @NonNull
    public final ImageView bMk;
    @NonNull
    public final TextView bMl;
    @NonNull
    public final ImageView bll;

    protected abi(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        super(dataBindingComponent, view, i);
        this.bMj = textView;
        this.bMk = imageView;
        this.bMl = textView2;
        this.bll = imageView2;
    }
}
