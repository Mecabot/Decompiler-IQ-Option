package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: DepositTermsLayoutBinding */
public abstract class hl extends ViewDataBinding {
    @NonNull
    public final LinearLayout bra;
    @NonNull
    public final AppCompatCheckBox brb;
    @NonNull
    public final TextView brc;

    protected hl(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, AppCompatCheckBox appCompatCheckBox, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bra = linearLayout;
        this.brb = appCompatCheckBox;
        this.brc = textView;
    }
}
