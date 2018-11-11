package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: LeftMenuItemDropDownBinding */
public abstract class xs extends ViewDataBinding {
    @NonNull
    public final TextView bKs;
    @NonNull
    public final ImageView bKw;
    @NonNull
    public final ImageView bKx;

    protected xs(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bKw = imageView;
        this.bKx = imageView2;
        this.bKs = textView;
    }
}
