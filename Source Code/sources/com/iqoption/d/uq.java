package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.iqoption.x.R;

/* compiled from: FragmentWithdrawMethodsBinding */
public abstract class uq extends ViewDataBinding {
    @NonNull
    public final LinearLayout bHn;

    protected uq(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.bHn = linearLayout;
    }

    @NonNull
    public static uq I(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return I(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static uq I(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (uq) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_withdraw_methods, viewGroup, z, dataBindingComponent);
    }
}
