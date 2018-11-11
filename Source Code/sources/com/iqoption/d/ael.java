package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: PortfolioDelegateMicroBinding */
public abstract class ael extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final Guideline awT;
    @NonNull
    public final ImageView axz;
    @NonNull
    public final TextView bAZ;
    @NonNull
    public final TabLayout bPJ;
    @NonNull
    public final ViewPager bmI;

    protected ael(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ViewPager viewPager, TabLayout tabLayout, TextView textView2, Guideline guideline) {
        super(dataBindingComponent, view, i);
        this.axz = imageView;
        this.bAZ = textView;
        this.bmI = viewPager;
        this.bPJ = tabLayout;
        this.agA = textView2;
        this.awT = guideline;
    }
}
