package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* compiled from: FragmentQuizSplashPagerDelegateBinding */
public abstract class rt extends ViewDataBinding {
    @NonNull
    public final FrameLayout axh;
    @NonNull
    public final ImageView bBJ;
    @NonNull
    public final rl bBq;
    @NonNull
    public final ViewPager bmI;
    @NonNull
    public final ContentLoadingProgressBar bnn;

    protected rt(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, ImageView imageView, ViewPager viewPager, ContentLoadingProgressBar contentLoadingProgressBar, rl rlVar) {
        super(dataBindingComponent, view, i);
        this.axh = frameLayout;
        this.bBJ = imageView;
        this.bmI = viewPager;
        this.bnn = contentLoadingProgressBar;
        this.bBq = rlVar;
        setContainedBinding(this.bBq);
    }
}
