package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: ActivityChatBinding */
public abstract class ab extends ViewDataBinding {
    @NonNull
    public final FrameLayout biF;
    @NonNull
    public final FrameLayout biG;

    protected ab(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.biF = frameLayout;
        this.biG = frameLayout2;
    }
}
