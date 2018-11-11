package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: ActivityProTraderWebBinding */
public abstract class ah extends ViewDataBinding {
    @NonNull
    public final FrameLayout biM;

    protected ah(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.biM = frameLayout;
    }
}
