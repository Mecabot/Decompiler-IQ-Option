package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

/* compiled from: LayoutAmountSelectorCollapsedBinding */
public abstract class wt extends ViewDataBinding {
    @NonNull
    public final wh bJS;
    @NonNull
    public final ImageView bpW;

    protected wt(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, wh whVar) {
        super(dataBindingComponent, view, i);
        this.bpW = imageView;
        this.bJS = whVar;
        setContainedBinding(this.bJS);
    }
}
