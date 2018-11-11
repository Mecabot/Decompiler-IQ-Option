package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: LayoutPerformToolbarTitleLightBinding */
public abstract class bz extends ViewDataBinding {
    @NonNull
    public final LinearLayout bqH;
    @NonNull
    public final TextView cav;
    @NonNull
    public final LinearLayout caw;

    protected bz(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(dataBindingComponent, view, i);
        this.cav = textView;
        this.bqH = linearLayout;
        this.caw = linearLayout2;
    }
}
