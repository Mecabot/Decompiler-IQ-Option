package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ErrorLayoutBinding */
public abstract class i extends ViewDataBinding {
    @NonNull
    public final TextView bAU;
    @NonNull
    public final ImageView dkJ;

    protected i(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bAU = textView;
        this.dkJ = imageView;
    }
}
