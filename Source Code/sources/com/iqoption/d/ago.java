package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: PriceMovementsFilterOptionsBinding */
public abstract class ago extends ViewDataBinding {
    @NonNull
    public final TextView bPY;
    @NonNull
    public final TextView bPZ;
    @NonNull
    public final TextView bQa;
    @NonNull
    public final LinearLayout bvN;

    protected ago(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bPY = textView;
        this.bPZ = textView2;
        this.bvN = linearLayout;
        this.bQa = textView3;
    }
}
