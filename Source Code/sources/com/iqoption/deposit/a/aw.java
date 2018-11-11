package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ItemPresetLightBinding */
public abstract class aw extends ViewDataBinding {
    @NonNull
    public final TextView bZM;
    @NonNull
    public final FrameLayout bZN;
    @NonNull
    public final ImageView bZO;

    protected aw(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bZM = textView;
        this.bZN = frameLayout;
        this.bZO = imageView;
    }
}
