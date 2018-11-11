package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: LeftMenuItemNotificationBinding */
public abstract class xw extends ViewDataBinding {
    @NonNull
    public final TextView bKs;
    @NonNull
    public final ImageView bKx;

    protected xw(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bKx = imageView;
        this.bKs = textView;
    }
}
