package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: OtnLeaderBoardItemBinding */
public abstract class acy extends ViewDataBinding {
    @NonNull
    public final LinearLayout bMH;
    @NonNull
    public final ImageView bzA;
    @NonNull
    public final TextView bzJ;
    @NonNull
    public final TextView bzN;
    @NonNull
    public final TextView bzO;

    protected acy(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bzA = imageView;
        this.bzJ = textView;
        this.bMH = linearLayout;
        this.bzN = textView2;
        this.bzO = textView3;
    }
}
