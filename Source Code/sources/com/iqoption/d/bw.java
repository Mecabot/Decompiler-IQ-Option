package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.fragment.ah;

/* compiled from: CfdExpirationFragmentBinding */
public abstract class bw extends ViewDataBinding {
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final RecyclerView blU;
    @NonNull
    public final FrameLayout blV;
    @Bindable
    protected ah blW;

    public abstract void a(@Nullable ah ahVar);

    protected bw(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.blU = recyclerView;
        this.blV = frameLayout;
        this.bjF = frameLayout2;
    }
}
