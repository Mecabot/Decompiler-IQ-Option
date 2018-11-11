package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.fragment.cb;

/* compiled from: FragmentPushSettingsBinding */
public abstract class ql extends ViewDataBinding {
    @NonNull
    public final ProgressBar Hw;
    @NonNull
    public final LinearLayout aOX;
    @NonNull
    public final ImageView bAO;
    @NonNull
    public final LinearLayout bAP;
    @NonNull
    public final TextView bAQ;
    @NonNull
    public final RecyclerView bAR;
    @Bindable
    protected cb bAS;
    @NonNull
    public final FrameLayout bvY;
    @NonNull
    public final ImageView bwe;

    public abstract void a(@Nullable cb cbVar);

    protected ql(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, ImageView imageView2, LinearLayout linearLayout2, ProgressBar progressBar, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bvY = frameLayout;
        this.bAO = imageView;
        this.bAP = linearLayout;
        this.bAQ = textView;
        this.bwe = imageView2;
        this.aOX = linearLayout2;
        this.Hw = progressBar;
        this.bAR = recyclerView;
    }
}
