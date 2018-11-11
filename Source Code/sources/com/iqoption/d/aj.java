package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.FitsSystemWindowsFrameLayout;
import com.iqoption.view.SplashView;

/* compiled from: ActivityVerifyCardsBinding */
public abstract class aj extends ViewDataBinding {
    @NonNull
    public final SplashView biL;
    @NonNull
    public final FitsSystemWindowsFrameLayout biN;

    protected aj(DataBindingComponent dataBindingComponent, View view, int i, FitsSystemWindowsFrameLayout fitsSystemWindowsFrameLayout, SplashView splashView) {
        super(dataBindingComponent, view, i);
        this.biN = fitsSystemWindowsFrameLayout;
        this.biL = splashView;
    }
}
