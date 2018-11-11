package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: FragmentTechnicalLogBinding */
public abstract class sh extends ViewDataBinding {
    @NonNull
    public final FrameLayout bCc;
    @NonNull
    public final TextView buI;

    protected sh(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bCc = frameLayout;
        this.buI = textView;
    }
}
