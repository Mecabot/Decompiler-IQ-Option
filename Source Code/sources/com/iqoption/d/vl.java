package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: HighFrequencyPanelItemBinding */
public abstract class vl extends ViewDataBinding {
    @NonNull
    public final TextView bHW;
    @NonNull
    public final View bHX;
    @NonNull
    public final TextView bHY;

    protected vl(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, View view2, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bHW = textView;
        this.bHX = view2;
        this.bHY = textView2;
    }
}
