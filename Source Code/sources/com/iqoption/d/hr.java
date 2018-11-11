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

/* compiled from: DialogClosedDealsHeaderDoBinding */
public abstract class hr extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bro;
    @NonNull
    public final RobotoTextView brs;
    @NonNull
    public final RobotoTextView brt;
    @NonNull
    public final RobotoTextView bru;

    protected hr(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4) {
        super(dataBindingComponent, view, i);
        this.bro = robotoTextView;
        this.brs = robotoTextView2;
        this.brt = robotoTextView3;
        this.bru = robotoTextView4;
    }

    @NonNull
    public static hr p(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return p(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static hr p(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (hr) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_closed_deals_header_do, viewGroup, z, dataBindingComponent);
    }
}
