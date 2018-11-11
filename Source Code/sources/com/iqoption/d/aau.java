package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: MicroPortfolioPendingGroupItemBinding */
public abstract class aau extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final ImageView bLq;
    @NonNull
    public final TextView bLr;
    @NonNull
    public final TextView bnL;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final RobotoTextView bnl;

    protected aau(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, RobotoTextView robotoTextView, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bnL = textView;
        this.bLq = imageView2;
        this.bnN = textView2;
        this.bnl = robotoTextView;
        this.bLr = textView3;
    }

    @NonNull
    public static aau ad(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ad(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aau ad(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aau) DataBindingUtil.inflate(layoutInflater, R.layout.micro_portfolio_pending_group_item, viewGroup, z, dataBindingComponent);
    }
}
