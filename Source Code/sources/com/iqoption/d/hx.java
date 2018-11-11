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

/* compiled from: DialogClosedDealsHeaderListDoBinding */
public abstract class hx extends ViewDataBinding {
    protected hx(DataBindingComponent dataBindingComponent, View view, int i) {
        super(dataBindingComponent, view, i);
    }

    @NonNull
    public static hx s(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return s(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static hx s(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (hx) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_closed_deals_header_list_do, viewGroup, z, dataBindingComponent);
    }
}
