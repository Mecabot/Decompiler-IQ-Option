package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: MenuFragmentBinding */
public abstract class yy extends ViewDataBinding {
    @NonNull
    public final FrameLayout bLh;
    @NonNull
    public final FrameLayout bLi;

    protected yy(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.bLh = frameLayout;
        this.bLi = frameLayout2;
    }
}
