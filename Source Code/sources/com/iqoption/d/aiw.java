package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: SellingPriceLayoutBinding */
public abstract class aiw extends ViewDataBinding {
    @NonNull
    public final TextView bNe;
    @NonNull
    public final TextView bTl;

    protected aiw(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bNe = textView;
        this.bTl = textView2;
    }
}
