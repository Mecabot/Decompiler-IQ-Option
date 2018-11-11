package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: PriceMovementsAttentionBinding */
public abstract class agi extends ViewDataBinding {
    @NonNull
    public final TextView bPT;
    @NonNull
    public final LinearLayout bPU;

    protected agi(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.bPT = textView;
        this.bPU = linearLayout;
    }
}
