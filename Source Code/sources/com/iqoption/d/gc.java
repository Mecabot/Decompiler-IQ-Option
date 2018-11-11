package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: DepositConstructorViewBinding */
public abstract class gc extends ViewDataBinding {
    @NonNull
    public final FrameLayout boQ;
    @NonNull
    public final LinearLayout boV;
    @NonNull
    public final View boW;
    @NonNull
    public final TextView boX;

    protected gc(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, FrameLayout frameLayout, View view2, TextView textView) {
        super(dataBindingComponent, view, i);
        this.boV = linearLayout;
        this.boQ = frameLayout;
        this.boW = view2;
        this.boX = textView;
    }
}
