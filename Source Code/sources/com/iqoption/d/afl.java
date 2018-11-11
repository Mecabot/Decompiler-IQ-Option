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

/* compiled from: PortfolioOpenHeaderItemBinding */
public abstract class afl extends ViewDataBinding {
    @NonNull
    public final TextView bPQ;

    protected afl(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bPQ = textView;
    }

    @NonNull
    public static afl au(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return au(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static afl au(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (afl) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_open_header_item, viewGroup, z, dataBindingComponent);
    }
}
