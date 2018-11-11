package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: LayoutNavigatorContentBinding */
public abstract class bu extends ViewDataBinding {
    @NonNull
    public final FrameLayout can;
    @NonNull
    public final FrameLayout cao;

    protected bu(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.can = frameLayout;
        this.cao = frameLayout2;
    }
}
