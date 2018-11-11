package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: LayoutDepositButtonLightBinding */
public abstract class bk extends ViewDataBinding {
    @NonNull
    public final FrameLayout bZV;
    @NonNull
    public final ContentLoadingProgressBar bZW;
    @NonNull
    public final TextView bZX;

    protected bk(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bZV = frameLayout;
        this.bZW = contentLoadingProgressBar;
        this.bZX = textView;
    }
}
