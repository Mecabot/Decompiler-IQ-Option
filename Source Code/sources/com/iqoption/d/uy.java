package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentWithdrawalCryptoKycBinding */
public abstract class uy extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView aip;
    @NonNull
    public final TextView bHz;

    protected uy(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bHz = textView;
        this.aip = textView2;
        this.agA = textView3;
    }
}
