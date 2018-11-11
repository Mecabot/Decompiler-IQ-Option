package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.feed.feedlist.TagLayout;

/* compiled from: MacroVideoFeedBinding */
public abstract class yw extends ViewDataBinding {
    @NonNull
    public final kr bKQ;
    @NonNull
    public final kv bKR;
    @NonNull
    public final TextView bKT;
    @NonNull
    public final TagLayout bKU;
    @NonNull
    public final TextView bLb;
    @NonNull
    public final ImageView bLc;
    @NonNull
    public final FrameLayout bLd;
    @NonNull
    public final ConstraintLayout bLe;
    @NonNull
    public final ImageView bLf;
    @NonNull
    public final TextView bLg;

    protected yw(DataBindingComponent dataBindingComponent, View view, int i, kr krVar, kv kvVar, TextView textView, ImageView imageView, TextView textView2, TagLayout tagLayout, FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bKQ = krVar;
        setContainedBinding(this.bKQ);
        this.bKR = kvVar;
        setContainedBinding(this.bKR);
        this.bLb = textView;
        this.bLc = imageView;
        this.bKT = textView2;
        this.bKU = tagLayout;
        this.bLd = frameLayout;
        this.bLe = constraintLayout;
        this.bLf = imageView2;
        this.bLg = textView3;
    }
}
