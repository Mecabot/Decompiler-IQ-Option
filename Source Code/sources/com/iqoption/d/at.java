package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.fragment.base.g;

/* compiled from: BaseMenuFragmentBinding */
public abstract class at extends ViewDataBinding {
    @NonNull
    public final FrameLayout blc;
    @Bindable
    protected g bld;

    public abstract void a(@Nullable g gVar);

    protected at(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.blc = frameLayout;
    }
}
