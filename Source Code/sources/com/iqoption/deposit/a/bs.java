package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: LayoutDepositToolbarBinding */
public abstract class bs extends ViewDataBinding {
    @NonNull
    public final ContentLoadingProgressBar aOW;
    @NonNull
    public final ImageView bTH;
    @NonNull
    public final TextView boG;
    @NonNull
    public final TextView cal;
    @NonNull
    public final FrameLayout cam;

    protected bs(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, FrameLayout frameLayout, ContentLoadingProgressBar contentLoadingProgressBar) {
        super(dataBindingComponent, view, i);
        this.boG = textView;
        this.bTH = imageView;
        this.cal = textView2;
        this.cam = frameLayout;
        this.aOW = contentLoadingProgressBar;
    }
}
