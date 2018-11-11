package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentQuizQuestionLanguageBinding */
public abstract class rr extends ViewDataBinding {
    @NonNull
    public final TextView aip;
    @NonNull
    public final ImageView bBI;

    protected rr(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bBI = imageView;
        this.aip = textView;
    }
}
