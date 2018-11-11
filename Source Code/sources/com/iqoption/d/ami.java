package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: WhatsNewVideoDialogBinding */
public abstract class ami extends ViewDataBinding {
    @NonNull
    public final TextView aip;
    @NonNull
    public final ImageView bLc;
    @NonNull
    public final ImageView bUM;
    @NonNull
    public final FrameLayout bUN;
    @NonNull
    public final RelativeLayout bUO;
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final ImageView btH;
    @NonNull
    public final LinearLayout bwR;

    protected ami(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout2, TextView textView, RelativeLayout relativeLayout) {
        super(dataBindingComponent, view, i);
        this.btH = imageView;
        this.bwR = linearLayout;
        this.bjF = frameLayout;
        this.bUM = imageView2;
        this.bLc = imageView3;
        this.bUN = frameLayout2;
        this.aip = textView;
        this.bUO = relativeLayout;
    }
}
