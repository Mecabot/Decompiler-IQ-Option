package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.feed.feedlist.TagLayout;

/* compiled from: MacroTweetFeedBinding */
public abstract class yu extends ViewDataBinding {
    @NonNull
    public final kr bKQ;
    @NonNull
    public final kv bKR;
    @NonNull
    public final TextView bKT;
    @NonNull
    public final TagLayout bKU;
    @NonNull
    public final ConstraintLayout bKY;
    @NonNull
    public final TextView bKZ;
    @NonNull
    public final ImageView bLa;
    @NonNull
    public final TextView bmr;

    protected yu(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, kr krVar, kv kvVar, ConstraintLayout constraintLayout, TextView textView2, TagLayout tagLayout, TextView textView3, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bmr = textView;
        this.bKQ = krVar;
        setContainedBinding(this.bKQ);
        this.bKR = kvVar;
        setContainedBinding(this.bKR);
        this.bKY = constraintLayout;
        this.bKT = textView2;
        this.bKU = tagLayout;
        this.bKZ = textView3;
        this.bLa = imageView;
    }
}
