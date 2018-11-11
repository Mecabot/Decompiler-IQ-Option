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
import com.iqoption.x.R;

/* compiled from: PortfolioCfdGroupItemBinding */
public abstract class ady extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final TextView agQ;
    @NonNull
    public final ImageView bLq;
    @NonNull
    public final TextView bLr;
    @NonNull
    public final TextView bnL;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final TextView bns;

    protected ady(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bnL = textView;
        this.bLq = imageView2;
        this.bnN = textView2;
        this.agQ = textView3;
        this.bLr = textView4;
        this.bns = textView5;
    }

    @NonNull
    public static ady ak(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ak(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ady ak(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (ady) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_cfd_group_item, viewGroup, z, dataBindingComponent);
    }
}
