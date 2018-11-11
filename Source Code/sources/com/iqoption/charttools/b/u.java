package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: IndicatorConstructorInputSelectBinding */
public abstract class u extends ViewDataBinding {
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final TextView avo;
    @NonNull
    public final TextView axE;

    protected u(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.avm = linearLayout;
        this.axE = textView;
        this.avo = textView2;
    }
}
