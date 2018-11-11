package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: NfcScanFragmentBinding */
public abstract class ce extends ViewDataBinding {
    @NonNull
    public final TextView bMl;
    @NonNull
    public final LottieAnimationView cax;
    @NonNull
    public final RelativeLayout cay;
    @NonNull
    public final TextView caz;

    protected ce(DataBindingComponent dataBindingComponent, View view, int i, LottieAnimationView lottieAnimationView, TextView textView, RelativeLayout relativeLayout, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.cax = lottieAnimationView;
        this.bMl = textView;
        this.cay = relativeLayout;
        this.caz = textView2;
    }
}
