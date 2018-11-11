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
import com.iqoption.widget.PreventScrollingTextView;

/* compiled from: MicroOtherVideoFeedBinding */
public abstract class zg extends ViewDataBinding {
    @NonNull
    public final TextView bKT;
    @NonNull
    public final TagLayout bKU;
    @NonNull
    public final ImageView bLc;
    @NonNull
    public final ConstraintLayout bLe;
    @NonNull
    public final ImageView bLf;
    @NonNull
    public final zc bLj;
    @NonNull
    public final ze bLk;
    @NonNull
    public final FrameLayout bLo;
    @NonNull
    public final PreventScrollingTextView bLp;

    protected zg(DataBindingComponent dataBindingComponent, View view, int i, zc zcVar, ze zeVar, ImageView imageView, TextView textView, TagLayout tagLayout, FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView2, PreventScrollingTextView preventScrollingTextView) {
        super(dataBindingComponent, view, i);
        this.bLj = zcVar;
        setContainedBinding(this.bLj);
        this.bLk = zeVar;
        setContainedBinding(this.bLk);
        this.bLc = imageView;
        this.bKT = textView;
        this.bKU = tagLayout;
        this.bLo = frameLayout;
        this.bLe = constraintLayout;
        this.bLf = imageView2;
        this.bLp = preventScrollingTextView;
    }
}
