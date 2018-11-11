package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: WinnerItemBinding */
public abstract class y extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final LinearLayout bUx;
    @NonNull
    public final ImageView bmj;
    @NonNull
    public final TextView btG;
    @NonNull
    public final TextView dle;

    protected y(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.btG = textView;
        this.bmj = imageView;
        this.bUx = linearLayout;
        this.aig = textView2;
        this.dle = textView3;
    }
}
