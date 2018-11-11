package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

/* compiled from: LayoutProTraderBenefitsBottomRowBinding */
public abstract class wx extends ViewDataBinding {
    @NonNull
    public final LinearLayout bJV;
    @NonNull
    public final View bJW;
    @NonNull
    public final Space bJX;
    @NonNull
    public final TextView bJY;

    protected wx(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, View view2, Space space, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bJV = linearLayout;
        this.bJW = view2;
        this.bJX = space;
        this.bJY = textView;
    }
}
