package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.x.R;

/* compiled from: MicroPortfolioOpenEmptyItemBinding */
public abstract class aai extends ViewDataBinding {
    protected aai(DataBindingComponent dataBindingComponent, View view, int i) {
        super(dataBindingComponent, view, i);
    }

    @NonNull
    public static aai aa(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return aa(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aai aa(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aai) DataBindingUtil.inflate(layoutInflater, R.layout.micro_portfolio_open_empty_item, viewGroup, z, dataBindingComponent);
    }
}
