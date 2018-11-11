package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: IndicatorInfoItemBinding */
public abstract class vp extends ViewDataBinding {
    @NonNull
    public final TextView aip;
    @NonNull
    public final TextView bIn;

    protected vp(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.aip = textView;
        this.bIn = textView2;
    }
}
