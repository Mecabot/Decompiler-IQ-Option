package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/* compiled from: LayoutWelcomePolicyBinding */
public abstract class xd extends ViewDataBinding {
    @NonNull
    public final CheckBox bEW;
    @NonNull
    public final TextView bEX;

    protected xd(DataBindingComponent dataBindingComponent, View view, int i, CheckBox checkBox, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bEW = checkBox;
        this.bEX = textView;
    }
}
