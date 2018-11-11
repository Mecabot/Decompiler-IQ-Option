package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.fragment.bq;

/* compiled from: FragmentMultiplierChooserBinding */
public abstract class ot extends ViewDataBinding {
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final RecyclerView bze;
    @Bindable
    protected bq bzf;

    public abstract void a(@Nullable bq bqVar);

    protected ot(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.blV = frameLayout;
        this.bze = recyclerView;
    }
}
