package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: ActivityWithdrawBinding */
public abstract class an extends ViewDataBinding {
    @NonNull
    public final NestedScrollView biR;
    @NonNull
    public final FrameLayout biS;
    @NonNull
    public final FrameLayout biT;
    @NonNull
    public final FrameLayout biU;
    @NonNull
    public final FrameLayout biV;
    @NonNull
    public final FrameLayout biW;

    protected an(DataBindingComponent dataBindingComponent, View view, int i, NestedScrollView nestedScrollView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5) {
        super(dataBindingComponent, view, i);
        this.biR = nestedScrollView;
        this.biS = frameLayout;
        this.biT = frameLayout2;
        this.biU = frameLayout3;
        this.biV = frameLayout4;
        this.biW = frameLayout5;
    }
}
