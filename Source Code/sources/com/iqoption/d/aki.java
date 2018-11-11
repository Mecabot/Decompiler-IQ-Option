package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ToolbarBlackLayoutBinding */
public abstract class aki extends ViewDataBinding {
    @NonNull
    public final LinearLayout aOV;
    @NonNull
    public final ContentLoadingProgressBar aOW;
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageButton bNY;
    @NonNull
    public final ImageView bTG;
    @NonNull
    public final ImageView blw;

    protected aki(DataBindingComponent dataBindingComponent, View view, int i, ImageButton imageButton, ImageView imageView, ImageView imageView2, TextView textView, LinearLayout linearLayout, ContentLoadingProgressBar contentLoadingProgressBar) {
        super(dataBindingComponent, view, i);
        this.bNY = imageButton;
        this.bTG = imageView;
        this.blw = imageView2;
        this.agA = textView;
        this.aOV = linearLayout;
        this.aOW = contentLoadingProgressBar;
    }
}
