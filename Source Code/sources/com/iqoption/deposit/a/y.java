package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentPaymentFieldsBinding */
public abstract class y extends ViewDataBinding {
    @NonNull
    public final LinearLayout bZy;
    @NonNull
    public final TextView bZz;

    protected y(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bZy = linearLayout;
        this.bZz = textView;
    }
}
