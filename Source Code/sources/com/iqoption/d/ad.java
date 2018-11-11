package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: ActivityPendingRemovalBinding */
public abstract class ad extends ViewDataBinding {
    @NonNull
    public final FrameLayout biI;

    protected ad(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.biI = frameLayout;
    }
}
