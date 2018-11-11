package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: IndicatorConstructorGroupDescriptionItemBinding */
public abstract class i extends ViewDataBinding {
    @NonNull
    public final TextView axy;

    protected i(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.axy = textView;
    }
}
