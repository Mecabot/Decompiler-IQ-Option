package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: PortfolioPendingHeaderItemBinding */
public abstract class afv extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bru;

    protected afv(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bru = robotoTextView;
    }

    @NonNull
    public static afv ax(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ax(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static afv ax(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (afv) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_pending_header_item, viewGroup, z, dataBindingComponent);
    }
}
