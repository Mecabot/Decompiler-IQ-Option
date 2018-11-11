package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: WithdrawMethodCardLayoutBinding */
public abstract class amv extends ViewDataBinding {
    @NonNull
    public final CardView2 bHs;
    @NonNull
    public final ImageView bVd;
    @NonNull
    public final TextView bVe;
    @NonNull
    public final TextView bVf;

    protected amv(DataBindingComponent dataBindingComponent, View view, int i, CardView2 cardView2, ImageView imageView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bHs = cardView2;
        this.bVd = imageView;
        this.bVe = textView;
        this.bVf = textView2;
    }

    @NonNull
    public static amv aE(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return aE(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static amv aE(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (amv) DataBindingUtil.inflate(layoutInflater, R.layout.withdraw_method_card_layout, viewGroup, z, dataBindingComponent);
    }
}
