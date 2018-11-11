package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: DialogPendingRemovalBinding */
public abstract class jd extends ViewDataBinding {
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final TextView btj;
    @NonNull
    public final ContentLoadingProgressBar btk;
    @NonNull
    public final LinearLayout btl;
    @NonNull
    public final TextView btm;
    @NonNull
    public final TextView btn;

    protected jd(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, ContentLoadingProgressBar contentLoadingProgressBar, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bjF = frameLayout;
        this.btj = textView;
        this.btk = contentLoadingProgressBar;
        this.btl = linearLayout;
        this.btm = textView2;
        this.btn = textView3;
    }
}
