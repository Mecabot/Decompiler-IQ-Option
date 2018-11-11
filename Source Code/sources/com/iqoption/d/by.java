package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

/* compiled from: ChatAttachmentImageItemBinding */
public abstract class by extends ViewDataBinding {
    @NonNull
    public final ImageView blY;
    @NonNull
    public final ImageView blZ;

    protected by(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2) {
        super(dataBindingComponent, view, i);
        this.blY = imageView;
        this.blZ = imageView2;
    }
}
