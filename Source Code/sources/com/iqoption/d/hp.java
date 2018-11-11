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

/* compiled from: DialogClosedDealsHeaderCfdBinding */
public abstract class hp extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bro;
    @NonNull
    public final RobotoTextView brp;
    @NonNull
    public final RobotoTextView brq;
    @NonNull
    public final RobotoTextView brr;

    protected hp(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4) {
        super(dataBindingComponent, view, i);
        this.bro = robotoTextView;
        this.brp = robotoTextView2;
        this.brq = robotoTextView3;
        this.brr = robotoTextView4;
    }

    @NonNull
    public static hp o(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return o(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static hp o(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (hp) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_closed_deals_header_cfd, viewGroup, z, dataBindingComponent);
    }
}
