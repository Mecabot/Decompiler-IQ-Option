package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: VideoEducationTagItemBinding */
public abstract class alm extends ViewDataBinding {
    @NonNull
    public final TextView aip;

    protected alm(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.aip = textView;
    }
}
