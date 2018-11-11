package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ChatFragmentImagePreviewBinding */
public abstract class da extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView awN;
    @NonNull
    public final ImageView blY;
    @NonNull
    public final ImageView bmD;
    @NonNull
    public final TextView bmE;
    @NonNull
    public final Guideline bmF;

    protected da(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, Guideline guideline) {
        super(dataBindingComponent, view, i);
        this.awN = imageView;
        this.bmD = imageView2;
        this.blY = imageView3;
        this.bmE = textView;
        this.agA = textView2;
        this.bmF = guideline;
    }
}
