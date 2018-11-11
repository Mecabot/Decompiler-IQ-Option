package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.fragment.account.security.AccountSecurityFragment;
import com.iqoption.view.SmoothViewPager;

/* compiled from: FragmentAccountSecurityBinding */
public abstract class kz extends ViewDataBinding {
    @NonNull
    public final LinearLayout aOX;
    @NonNull
    public final FrameLayout bvY;
    @NonNull
    public final ImageView bvZ;
    @NonNull
    public final ImageView bwa;
    @NonNull
    public final ImageView bwb;
    @NonNull
    public final ImageView bwc;
    @NonNull
    public final LinearLayout bwd;
    @NonNull
    public final ImageView bwe;
    @NonNull
    public final ImageView bwf;
    @NonNull
    public final ImageView bwg;
    @NonNull
    public final ImageView bwh;
    @NonNull
    public final LinearLayout bwi;
    @NonNull
    public final FrameLayout bwj;
    @NonNull
    public final ImageView bwk;
    @NonNull
    public final ImageView bwl;
    @NonNull
    public final SmoothViewPager bwm;
    @Bindable
    protected AccountSecurityFragment bwn;

    public abstract void a(@Nullable AccountSecurityFragment accountSecurityFragment);

    protected kz(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout2, ImageView imageView8, LinearLayout linearLayout3, FrameLayout frameLayout2, ImageView imageView9, ImageView imageView10, SmoothViewPager smoothViewPager) {
        super(dataBindingComponent, view, i);
        this.bvY = frameLayout;
        this.bvZ = imageView;
        this.bwa = imageView2;
        this.bwb = imageView3;
        this.bwc = imageView4;
        this.bwd = linearLayout;
        this.bwe = imageView5;
        this.bwf = imageView6;
        this.bwg = imageView7;
        this.aOX = linearLayout2;
        this.bwh = imageView8;
        this.bwi = linearLayout3;
        this.bwj = frameLayout2;
        this.bwk = imageView9;
        this.bwl = imageView10;
        this.bwm = smoothViewPager;
    }
}
