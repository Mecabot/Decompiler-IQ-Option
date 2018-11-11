package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: FragmentQuizBinding */
public abstract class qn extends ViewDataBinding {
    @NonNull
    public final FrameLayout axh;

    protected qn(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.axh = frameLayout;
    }
}
