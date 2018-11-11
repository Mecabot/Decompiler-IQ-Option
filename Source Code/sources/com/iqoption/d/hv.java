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

/* compiled from: DialogClosedDealsHeaderListCfdBinding */
public abstract class hv extends ViewDataBinding {
    @NonNull
    public final RobotoTextView brv;

    protected hv(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.brv = robotoTextView;
    }

    @NonNull
    public static hv r(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return r(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static hv r(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (hv) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_closed_deals_header_list_cfd, viewGroup, z, dataBindingComponent);
    }
}
