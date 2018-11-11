package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ChatFragmentImagePreviewSliderBinding */
public abstract class dc extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView blZ;
    @NonNull
    public final ImageView bmG;
    @NonNull
    public final TextView bmH;
    @NonNull
    public final ViewPager bmI;

    protected dc(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ViewPager viewPager, ImageView imageView2, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bmG = imageView;
        this.bmH = textView;
        this.bmI = viewPager;
        this.blZ = imageView2;
        this.agA = textView2;
    }
}
