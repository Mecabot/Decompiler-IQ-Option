package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* compiled from: MultiAssetViewBinding */
public abstract class abk extends ViewDataBinding {
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final ImageView bMm;
    @NonNull
    public final HorizontalScrollView bMn;

    protected abk(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, HorizontalScrollView horizontalScrollView) {
        super(dataBindingComponent, view, i);
        this.bMm = imageView;
        this.avm = linearLayout;
        this.bMn = horizontalScrollView;
    }
}
