package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: MicroPortfolioTotalPagerPageBinding */
public abstract class abc extends ViewDataBinding {
    @NonNull
    public final TextView avo;
    @NonNull
    public final TextView bns;

    protected abc(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.avo = textView;
        this.bns = textView2;
    }
}
