package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentProTraderMoreBinding */
public abstract class qf extends ViewDataBinding {
    @NonNull
    public final TextView bAC;
    @NonNull
    public final TextView bAD;
    @NonNull
    public final LinearLayout bAE;
    @NonNull
    public final TextView bAF;

    protected qf(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bAC = textView;
        this.bAD = textView2;
        this.bAE = linearLayout;
        this.bAF = textView3;
    }
}
