package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: SmartFeedFragmentBinding */
public abstract class ajo extends ViewDataBinding {
    @NonNull
    public final FrameLayout bTt;

    protected ajo(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.bTt = frameLayout;
    }
}
