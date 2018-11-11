package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.view.SplashView;

/* compiled from: ActivityProDepositBinding */
public abstract class af extends ViewDataBinding {
    @NonNull
    public final FrameLayout biJ;
    @NonNull
    public final FrameLayout biK;
    @NonNull
    public final SplashView biL;

    protected af(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, SplashView splashView) {
        super(dataBindingComponent, view, i);
        this.biJ = frameLayout;
        this.biK = frameLayout2;
        this.biL = splashView;
    }
}
