package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: FragmentTraderoomRestrictionBinding */
public abstract class sn extends ViewDataBinding {
    @NonNull
    public final TextView aip;
    @NonNull
    public final RobotoTextView bDr;
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final TextView brN;
    @NonNull
    public final FrameLayout bxe;
    @NonNull
    public final LinearLayout bxi;

    protected sn(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, LinearLayout linearLayout, TextView textView2, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bxe = frameLayout;
        this.brN = textView;
        this.blV = frameLayout2;
        this.bxi = linearLayout;
        this.aip = textView2;
        this.bDr = robotoTextView;
    }
}
