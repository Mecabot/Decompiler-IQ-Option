package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

/* compiled from: DialpadKeyBackBinding */
public abstract class kf extends ViewDataBinding {
    @NonNull
    public final ImageView bvd;

    protected kf(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bvd = imageView;
    }
}
