package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FeedTitleBinding */
public abstract class kv extends ViewDataBinding {
    @NonNull
    public final ImageView bvP;
    @NonNull
    public final ImageView bvQ;
    @NonNull
    public final TextView bvR;

    protected kv(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bvP = imageView;
        this.bvQ = imageView2;
        this.bvR = textView;
    }
}
