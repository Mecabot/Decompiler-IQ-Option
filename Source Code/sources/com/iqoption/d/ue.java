package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.scoreboard.OnlineCountBoard;
import com.iqoption.welcomeonboarding.c.d;

/* compiled from: FragmentWelcomeOnboardingBinding */
public abstract class ue extends ViewDataBinding {
    @NonNull
    public final TextView bGs;
    @NonNull
    public final TextView bGt;
    @NonNull
    public final Button bGu;
    @NonNull
    public final LinearLayout bGv;
    @NonNull
    public final OnlineCountBoard bGw;
    @NonNull
    public final LinearLayout bGx;
    @NonNull
    public final ViewPager bGy;
    @Bindable
    protected d bGz;

    public abstract void a(@Nullable d dVar);

    protected ue(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, Button button, LinearLayout linearLayout, OnlineCountBoard onlineCountBoard, LinearLayout linearLayout2, ViewPager viewPager) {
        super(dataBindingComponent, view, i);
        this.bGs = textView;
        this.bGt = textView2;
        this.bGu = button;
        this.bGv = linearLayout;
        this.bGw = onlineCountBoard;
        this.bGx = linearLayout2;
        this.bGy = viewPager;
    }
}
