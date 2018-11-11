package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: DialogProApplicationStatusBinding */
public abstract class jh extends ViewDataBinding {
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final LinearLayout btr;
    @NonNull
    public final TextView bts;
    @NonNull
    public final TextView btt;

    protected jh(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bjF = frameLayout;
        this.btr = linearLayout;
        this.bts = textView;
        this.btt = textView2;
    }
}
