package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: PriceMovementsTittleItemBinding */
public abstract class aha extends ViewDataBinding {
    @NonNull
    public final TextView bQr;

    protected aha(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bQr = textView;
    }
}
