package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: LayoutDialogToolbarBinding */
public abstract class wv extends ViewDataBinding {
    @NonNull
    public final ImageView bJT;
    @NonNull
    public final TextView bJU;

    protected wv(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bJT = imageView;
        this.bJU = textView;
    }
}
