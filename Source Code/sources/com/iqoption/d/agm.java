package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: PriceMovementsFilterMenuItemBinding */
public abstract class agm extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView bPW;

    protected agm(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bPW = imageView;
        this.agA = textView;
    }
}
