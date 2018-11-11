package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentOtnLeadingBoardUserBoardPlaceBinding */
public abstract class pr extends ViewDataBinding {
    @NonNull
    public final ImageView bAb;
    @NonNull
    public final TextView bAc;
    @NonNull
    public final TextView bzJ;

    protected pr(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bAb = imageView;
        this.bzJ = textView;
        this.bAc = textView2;
    }
}
