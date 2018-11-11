package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

/* compiled from: DialogGdprWarningBinding */
public abstract class in extends ViewDataBinding {
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final TextView bse;
    @NonNull
    public final ContentLoadingProgressBar bsf;
    @NonNull
    public final LinearLayout bsg;
    @NonNull
    public final Space bsh;
    @NonNull
    public final Space bsi;
    @NonNull
    public final Space bsj;
    @NonNull
    public final ImageView bsk;
    @NonNull
    public final TextView bsl;
    @NonNull
    public final TextView bsm;

    protected in(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, ContentLoadingProgressBar contentLoadingProgressBar, LinearLayout linearLayout, Space space, Space space2, Space space3, ImageView imageView, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bjF = frameLayout;
        this.bse = textView;
        this.bsf = contentLoadingProgressBar;
        this.bsg = linearLayout;
        this.bsh = space;
        this.bsi = space2;
        this.bsj = space3;
        this.bsk = imageView;
        this.bsl = textView2;
        this.bsm = textView3;
    }
}
