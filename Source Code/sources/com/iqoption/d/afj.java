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

/* compiled from: PortfolioOpenEmptyItemBinding */
public abstract class afj extends ViewDataBinding {
    protected afj(DataBindingComponent dataBindingComponent, View view, int i) {
        super(dataBindingComponent, view, i);
    }

    @NonNull
    public static afj at(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return at(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static afj at(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (afj) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_open_empty_item, viewGroup, z, dataBindingComponent);
    }
}
