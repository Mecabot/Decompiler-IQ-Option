package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: MacroFeedTitleBinding */
public abstract class yq extends ViewDataBinding {
    @NonNull
    public final TextView bKT;
    @NonNull
    public final TextView bKW;
    @NonNull
    public final ImageView bvQ;

    protected yq(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bvQ = imageView;
        this.bKW = textView;
        this.bKT = textView2;
    }
}
