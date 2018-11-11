package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: SessionMainItemBinding */
public abstract class aiy extends ViewDataBinding {
    @NonNull
    public final TextView aiF;
    @NonNull
    public final TextView bTm;
    @NonNull
    public final TextView bTn;
    @NonNull
    public final TextView bTo;
    @NonNull
    public final TextView bTp;
    @NonNull
    public final ImageView bmu;

    protected aiy(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.aiF = textView;
        this.bmu = imageView;
        this.bTm = textView2;
        this.bTn = textView3;
        this.bTo = textView4;
        this.bTp = textView5;
    }
}
