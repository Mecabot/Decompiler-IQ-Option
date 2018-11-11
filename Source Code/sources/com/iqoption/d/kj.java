package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

/* compiled from: DialpadKeyTouchidBinding */
public abstract class kj extends ViewDataBinding {
    @NonNull
    public final ImageView bvd;
    @NonNull
    public final ImageView bvg;
    @NonNull
    public final ImageView bvh;

    protected kj(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(dataBindingComponent, view, i);
        this.bvg = imageView;
        this.bvd = imageView2;
        this.bvh = imageView3;
    }
}
