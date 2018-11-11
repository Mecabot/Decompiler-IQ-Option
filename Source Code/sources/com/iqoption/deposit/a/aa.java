package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentPaymentFieldsLightBinding */
public abstract class aa extends ViewDataBinding {
    @NonNull
    public final LinearLayout bZA;
    @NonNull
    public final LinearLayout bZy;
    @NonNull
    public final TextView bZz;

    protected aa(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bZA = linearLayout;
        this.bZy = linearLayout2;
        this.bZz = textView;
    }
}
