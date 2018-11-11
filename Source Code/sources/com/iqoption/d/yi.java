package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: LegalUpdateBinding */
public abstract class yi extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView aip;
    @NonNull
    public final TextView bKH;
    @NonNull
    public final ConstraintLayout bKI;
    @NonNull
    public final FrameLayout blV;

    protected yi(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, ConstraintLayout constraintLayout, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bKH = textView;
        this.blV = frameLayout;
        this.bKI = constraintLayout;
        this.aip = textView2;
        this.agA = textView3;
    }
}
