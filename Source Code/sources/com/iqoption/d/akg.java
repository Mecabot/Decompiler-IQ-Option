package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: TemplateItemBinding */
public abstract class akg extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final ImageView bLv;
    @NonNull
    public final ImageView bTD;
    @NonNull
    public final TextView bTF;

    protected akg(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bLv = imageView;
        this.bTD = imageView2;
        this.axL = constraintLayout;
        this.bTF = textView;
        this.aig = textView2;
    }
}
