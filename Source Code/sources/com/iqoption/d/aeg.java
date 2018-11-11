package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.Space;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* compiled from: PortfolioDelegateBinding */
public abstract class aeg extends ViewDataBinding {
    @NonNull
    public final ImageView awN;
    @Nullable
    public final CoordinatorLayout bHC;
    @NonNull
    public final FrameLayout bPA;
    @Nullable
    public final View bPB;
    @NonNull
    public final adw bPC;
    @Nullable
    public final Space bPD;
    @Nullable
    public final ImageView bPE;
    @Nullable
    public final LinearLayout bPF;
    @Nullable
    public final CoordinatorLayout bPG;
    @Nullable
    public final Guideline bPH;
    @Nullable
    public final Guideline bPI;
    @NonNull
    public final TabLayout bPJ;
    @Nullable
    public final Space bPK;
    @NonNull
    public final agd bPL;
    @NonNull
    public final adq bPy;
    @NonNull
    public final AppBarLayout bPz;
    @NonNull
    public final ViewPager bmI;

    protected aeg(DataBindingComponent dataBindingComponent, View view, int i, adq adq, AppBarLayout appBarLayout, FrameLayout frameLayout, View view2, adw adw, Space space, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, Guideline guideline, ViewPager viewPager, Guideline guideline2, TabLayout tabLayout, Space space2, agd agd) {
        super(dataBindingComponent, view, i);
        this.bPy = adq;
        setContainedBinding(this.bPy);
        this.bPz = appBarLayout;
        this.bPA = frameLayout;
        this.bPB = view2;
        this.bPC = adw;
        setContainedBinding(this.bPC);
        this.bPD = space;
        this.awN = imageView;
        this.bPE = imageView2;
        this.bPF = linearLayout;
        this.bPG = coordinatorLayout;
        this.bHC = coordinatorLayout2;
        this.bPH = guideline;
        this.bmI = viewPager;
        this.bPI = guideline2;
        this.bPJ = tabLayout;
        this.bPK = space2;
        this.bPL = agd;
        setContainedBinding(this.bPL);
    }
}
