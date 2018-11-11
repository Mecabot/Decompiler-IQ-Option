package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: FragmentRightPanelBinding */
public abstract class rx extends ViewDataBinding {
    @NonNull
    public final TextView bBM;
    @NonNull
    public final FrameLayout bBN;

    protected rx(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.bBM = textView;
        this.bBN = frameLayout;
    }
}
