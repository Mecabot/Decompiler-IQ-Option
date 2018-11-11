package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ItemCountrySuggestBinding */
public abstract class vx extends ViewDataBinding {
    @NonNull
    public final LinearLayout bBU;
    @NonNull
    public final TextView bjy;

    protected vx(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bBU = linearLayout;
        this.bjy = textView;
    }
}
