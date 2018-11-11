package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.fragment.at;

/* compiled from: DigitalExpirationFragmentBinding */
public abstract class kn extends ViewDataBinding {
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final SwitchCompat bvi;
    @NonNull
    public final TextView bvj;
    @NonNull
    public final RecyclerView bvk;
    @NonNull
    public final LinearLayout bvl;
    @NonNull
    public final TextView bvm;
    @NonNull
    public final TextView bvn;
    @NonNull
    public final TabLayout bvo;
    @NonNull
    public final TextView bvp;
    @NonNull
    public final RecyclerView bvq;
    @NonNull
    public final TextView bvr;
    @Bindable
    protected at bvs;

    public abstract void a(@Nullable at atVar);

    protected kn(DataBindingComponent dataBindingComponent, View view, int i, SwitchCompat switchCompat, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, RecyclerView recyclerView, LinearLayout linearLayout, TextView textView2, TextView textView3, TabLayout tabLayout, TextView textView4, RecyclerView recyclerView2, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.bvi = switchCompat;
        this.blV = frameLayout;
        this.bjF = frameLayout2;
        this.bvj = textView;
        this.bvk = recyclerView;
        this.bvl = linearLayout;
        this.bvm = textView2;
        this.bvn = textView3;
        this.bvo = tabLayout;
        this.bvp = textView4;
        this.bvq = recyclerView2;
        this.bvr = textView5;
    }
}
