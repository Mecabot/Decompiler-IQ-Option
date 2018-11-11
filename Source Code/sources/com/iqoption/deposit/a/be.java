package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: LayoutCurrencySelectorBinding */
public abstract class be extends ViewDataBinding {
    @NonNull
    public final ImageView bZT;
    @NonNull
    public final TextView bZU;

    protected be(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bZT = imageView;
        this.bZU = textView;
    }
}
