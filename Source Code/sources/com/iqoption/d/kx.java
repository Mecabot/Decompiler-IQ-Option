package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FeedWebBinding */
public abstract class kx extends ViewDataBinding {
    @NonNull
    public final WebView EM;
    @NonNull
    public final FrameLayout bvS;
    @NonNull
    public final ConstraintLayout bvT;
    @NonNull
    public final ImageView bvU;
    @NonNull
    public final TextView bvV;
    @NonNull
    public final TextView bvW;
    @NonNull
    public final TextView bvX;

    protected kx(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, WebView webView) {
        super(dataBindingComponent, view, i);
        this.bvS = frameLayout;
        this.bvT = constraintLayout;
        this.bvU = imageView;
        this.bvV = textView;
        this.bvW = textView2;
        this.bvX = textView3;
        this.EM = webView;
    }
}
