package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: FragmentWithdrawalCryptoPagerBinding */
public abstract class va extends ViewDataBinding {
    @NonNull
    public final ViewPager bmI;
    @NonNull
    public final LinearLayout bwd;

    protected va(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, ViewPager viewPager) {
        super(dataBindingComponent, view, i);
        this.bwd = linearLayout;
        this.bmI = viewPager;
    }
}
