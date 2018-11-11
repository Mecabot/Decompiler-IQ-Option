package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: LayoutPayMethodSelectorBinding */
public abstract class bx extends ViewDataBinding {
    @NonNull
    public final TextView cap;
    @NonNull
    public final TextView caq;
    @NonNull
    public final LinearLayout car;
    @NonNull
    public final ImageView cas;
    @NonNull
    public final ConstraintLayout cat;
    @NonNull
    public final View cau;

    protected bx(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, ImageView imageView, ConstraintLayout constraintLayout, View view2) {
        super(dataBindingComponent, view, i);
        this.cap = textView;
        this.caq = textView2;
        this.car = linearLayout;
        this.cas = imageView;
        this.cat = constraintLayout;
        this.cau = view2;
    }
}
