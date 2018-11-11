package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentWithdrawalCrypto3dsBinding */
public abstract class uw extends ViewDataBinding {
    @NonNull
    public final TextView aip;
    @NonNull
    public final TextView bHy;

    protected uw(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bHy = textView;
        this.aip = textView2;
    }
}
