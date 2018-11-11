package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: DialpadKeyBinding */
public abstract class kh extends ViewDataBinding {
    @NonNull
    public final TextView bve;
    @NonNull
    public final TextView bvf;

    protected kh(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bve = textView;
        this.bvf = textView2;
    }
}
