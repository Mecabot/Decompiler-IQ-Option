package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.x.R;

/* compiled from: FragmentVerifyStatusBinding */
public abstract class tl extends ViewDataBinding {
    @NonNull
    public final TextView bFA;
    @NonNull
    public final FrameLayout bFB;
    @NonNull
    public final LottieAnimationView bFC;
    @NonNull
    public final FrameLayout bFD;
    @NonNull
    public final TextView bFE;
    @NonNull
    public final TextView bFy;
    @NonNull
    public final FrameLayout bFz;

    protected tl(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, TextView textView2, FrameLayout frameLayout2, LottieAnimationView lottieAnimationView, FrameLayout frameLayout3, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bFy = textView;
        this.bFz = frameLayout;
        this.bFA = textView2;
        this.bFB = frameLayout2;
        this.bFC = lottieAnimationView;
        this.bFD = frameLayout3;
        this.bFE = textView3;
    }

    @NonNull
    public static tl E(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return E(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static tl E(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (tl) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_verify_status, viewGroup, z, dataBindingComponent);
    }
}
