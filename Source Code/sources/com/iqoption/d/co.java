package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ChatFileMessageHeadItemBinding */
public abstract class co extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final TextView aiq;
    @NonNull
    public final TextView bmr;
    @NonNull
    public final LinearLayout bms;

    protected co(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bmr = textView;
        this.bms = linearLayout;
        this.aig = textView2;
        this.aiq = textView3;
    }
}
