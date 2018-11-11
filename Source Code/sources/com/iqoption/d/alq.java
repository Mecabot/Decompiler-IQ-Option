package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.fragment.dialog.whatsnew.a;
import com.iqoption.view.SmoothViewPager;

/* compiled from: ViewPagerWhatsNewDialogBinding */
public abstract class alq extends ViewDataBinding {
    @NonNull
    public final TextView bHU;
    @NonNull
    public final TextView bUl;
    @NonNull
    public final ImageView bll;
    @Bindable
    protected a bln;
    @NonNull
    public final ImageView bvZ;
    @NonNull
    public final ImageView bwa;
    @NonNull
    public final LinearLayout bwd;
    @NonNull
    public final SmoothViewPager bwm;

    public abstract void a(@Nullable a aVar);

    protected alq(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, SmoothViewPager smoothViewPager, ImageView imageView3, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bvZ = imageView;
        this.bwa = imageView2;
        this.bwd = linearLayout;
        this.bUl = textView;
        this.bwm = smoothViewPager;
        this.bll = imageView3;
        this.bHU = textView2;
    }
}
