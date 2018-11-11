package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: MicroPortfolioOpenHeaderItemBinding */
public abstract class aak extends ViewDataBinding {
    @NonNull
    public final TextView bMb;
    @NonNull
    public final TextView bMc;
    @NonNull
    public final TextView bMd;
    @NonNull
    public final TextView bMe;

    protected aak(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bMb = textView;
        this.bMc = textView2;
        this.bMd = textView3;
        this.bMe = textView4;
    }

    @NonNull
    public static aak ab(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ab(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aak ab(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aak) DataBindingUtil.inflate(layoutInflater, R.layout.micro_portfolio_open_header_item, viewGroup, z, dataBindingComponent);
    }
}
