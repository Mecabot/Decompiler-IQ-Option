package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* compiled from: ActivityWelcomeOnboardingBinding */
public abstract class al extends ViewDataBinding {
    @NonNull
    public final FrameLayout axh;
    @NonNull
    public final ImageView biO;
    @NonNull
    public final ImageView biP;
    @NonNull
    public final FrameLayout biQ;

    protected al(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.axh = frameLayout;
        this.biO = imageView;
        this.biP = imageView2;
        this.biQ = frameLayout2;
    }
}
