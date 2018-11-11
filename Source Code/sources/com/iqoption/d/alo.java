package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: VideoEducationVideoItemBinding */
public abstract class alo extends ViewDataBinding {
    @NonNull
    public final ImageView aEt;
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView bUi;
    @NonNull
    public final TextView bUj;
    @NonNull
    public final TextView bUk;
    @NonNull
    public final LinearLayout bjl;

    protected alo(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bjl = linearLayout;
        this.bUi = textView;
        this.aEt = imageView;
        this.bUj = textView2;
        this.agA = textView3;
        this.bUk = textView4;
    }
}
