package com.iqoption.core.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: LayoutToolbarBlackBinding */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final ImageView aOU;
    @NonNull
    public final LinearLayout aOV;
    @NonNull
    public final ContentLoadingProgressBar aOW;
    @NonNull
    public final TextView agA;

    protected a(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, ContentLoadingProgressBar contentLoadingProgressBar) {
        super(dataBindingComponent, view, i);
        this.aOU = imageView;
        this.agA = textView;
        this.aOV = linearLayout;
        this.aOW = contentLoadingProgressBar;
    }
}
