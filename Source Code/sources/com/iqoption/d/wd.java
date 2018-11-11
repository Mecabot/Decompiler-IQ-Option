package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ItemLocaleAssetCountrySuggestBinding */
public abstract class wd extends ViewDataBinding {
    @NonNull
    public final TextView bJl;
    @NonNull
    public final ConstraintLayout bJm;
    @NonNull
    public final ImageView bJn;
    @NonNull
    public final TextView bJo;
    @NonNull
    public final TextView bjy;

    protected wd(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ConstraintLayout constraintLayout, TextView textView2, ImageView imageView, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bJl = textView;
        this.bJm = constraintLayout;
        this.bjy = textView2;
        this.bJn = imageView;
        this.bJo = textView3;
    }
}
