package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Barrier;
import android.support.constraint.Guideline;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: PortfolioDelegateMacroBinding */
public abstract class aej extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView agQ;
    @NonNull
    public final ImageView awN;
    @NonNull
    public final Guideline awT;
    @NonNull
    public final TextView bAZ;
    @NonNull
    public final TabLayout bPJ;
    @NonNull
    public final Barrier bPN;
    @NonNull
    public final ViewPager bmI;
    @NonNull
    public final TextView bns;

    protected aej(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ViewPager viewPager, TextView textView2, TabLayout tabLayout, TextView textView3, Barrier barrier, Guideline guideline, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.awN = imageView;
        this.bAZ = textView;
        this.bmI = viewPager;
        this.agQ = textView2;
        this.bPJ = tabLayout;
        this.agA = textView3;
        this.bPN = barrier;
        this.awT = guideline;
        this.bns = textView4;
    }
}
