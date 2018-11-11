package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.timer.TimerView;

/* compiled from: AssetSpinnerHandleBinding */
public abstract class ar extends ViewDataBinding {
    @NonNull
    public final LinearLayout aOV;
    @NonNull
    public final ImageView bkS;
    @NonNull
    public final ImageView bkT;
    @NonNull
    public final TextView bkU;
    @NonNull
    public final TextView bkV;
    @NonNull
    public final FrameLayout bkW;
    @NonNull
    public final ImageView bkX;
    @NonNull
    public final View bkY;
    @NonNull
    public final LinearLayout bkZ;
    @NonNull
    public final ImageSwitcher bla;
    @NonNull
    public final TimerView blb;

    protected ar(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, FrameLayout frameLayout, ImageView imageView3, View view2, LinearLayout linearLayout, ImageSwitcher imageSwitcher, TimerView timerView, LinearLayout linearLayout2) {
        super(dataBindingComponent, view, i);
        this.bkS = imageView;
        this.bkT = imageView2;
        this.bkU = textView;
        this.bkV = textView2;
        this.bkW = frameLayout;
        this.bkX = imageView3;
        this.bkY = view2;
        this.bkZ = linearLayout;
        this.bla = imageSwitcher;
        this.blb = timerView;
        this.aOV = linearLayout2;
    }
}
