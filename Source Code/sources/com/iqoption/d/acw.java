package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: OtnLeaderBoardFirstItemBinding */
public abstract class acw extends ViewDataBinding {
    @NonNull
    public final LinearLayout bMH;
    @NonNull
    public final ImageView bNR;
    @NonNull
    public final ImageView bzA;
    @NonNull
    public final TextView bzN;
    @NonNull
    public final TextView bzO;

    protected acw(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bzA = imageView;
        this.bNR = imageView2;
        this.bMH = linearLayout;
        this.bzN = textView;
        this.bzO = textView2;
    }
}
