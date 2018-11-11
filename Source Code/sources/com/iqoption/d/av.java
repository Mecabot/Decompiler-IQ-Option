package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.fragment.base.h;

/* compiled from: BaseSmartDialogFragmentBinding */
public abstract class av extends ViewDataBinding {
    @NonNull
    public final FrameLayout blc;
    @NonNull
    public final FrameLayout ble;
    @Bindable
    protected h blf;

    public abstract void a(@Nullable h hVar);

    protected av(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.ble = frameLayout;
        this.blc = frameLayout2;
    }
}
