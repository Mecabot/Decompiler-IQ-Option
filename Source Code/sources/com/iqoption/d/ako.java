package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: ToolsContentIndicatorsBinding */
public abstract class ako extends ViewDataBinding {
    @NonNull
    public final TabLayout bPJ;
    @NonNull
    public final LinearLayout bTM;
    @NonNull
    public final ViewPager bmI;

    protected ako(DataBindingComponent dataBindingComponent, View view, int i, ViewPager viewPager, TabLayout tabLayout, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.bmI = viewPager;
        this.bPJ = tabLayout;
        this.bTM = linearLayout;
    }
}
