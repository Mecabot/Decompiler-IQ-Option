package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: VideoEducationCategoryItemBinding */
public abstract class alg extends ViewDataBinding {
    @NonNull
    public final ImageView aEt;
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView bUe;
    @NonNull
    public final TextView bUf;
    @NonNull
    public final TextView bUg;

    protected alg(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bUe = textView;
        this.aEt = imageView;
        this.bUf = textView2;
        this.agA = textView3;
        this.bUg = textView4;
    }
}
