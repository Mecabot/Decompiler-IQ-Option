package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;

/* compiled from: KycToolbarLayoutBinding */
public abstract class wr extends ViewDataBinding {
    @NonNull
    public final Toolbar toolbar;

    protected wr(DataBindingComponent dataBindingComponent, View view, int i, Toolbar toolbar) {
        super(dataBindingComponent, view, i);
        this.toolbar = toolbar;
    }
}
