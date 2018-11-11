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

/* compiled from: PortfolioExpHeaderItemBinding */
public abstract class aep extends ViewDataBinding {
    @NonNull
    public final TextView bLO;

    protected aep(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bLO = textView;
    }

    @NonNull
    public static aep ao(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ao(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aep ao(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aep) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_exp_header_item, viewGroup, z, dataBindingComponent);
    }
}
