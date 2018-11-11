package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: OnlineAndLifeCounterLayoutBinding */
public abstract class k extends ViewDataBinding {
    @NonNull
    public final TextView dkK;
    @NonNull
    public final ImageView dkL;
    @NonNull
    public final ImageView dkM;
    @NonNull
    public final TextView dkN;
    @NonNull
    public final View dkO;
    @NonNull
    public final ImageView dkw;
    @NonNull
    public final TextView dky;

    protected k(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView2, View view2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.dkK = textView;
        this.dkL = imageView;
        this.dkw = imageView2;
        this.dkM = imageView3;
        this.dkN = textView2;
        this.dkO = view2;
        this.dky = textView3;
    }
}
