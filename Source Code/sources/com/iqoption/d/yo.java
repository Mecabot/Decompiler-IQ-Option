package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: MacroFeedOptionsBinding */
public abstract class yo extends ViewDataBinding {
    @NonNull
    public final FrameLayout bKV;
    @NonNull
    public final TextView bvL;
    @NonNull
    public final TextView bvM;
    @NonNull
    public final LinearLayout bvN;
    @NonNull
    public final TextView bvO;

    protected yo(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.bvL = textView;
        this.bvM = textView2;
        this.bvN = linearLayout;
        this.bvO = textView3;
        this.bKV = frameLayout;
    }
}
