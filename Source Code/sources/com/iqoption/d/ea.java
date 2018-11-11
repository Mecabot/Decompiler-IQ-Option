package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* compiled from: ChatRoomCantSendLayoutBinding */
public abstract class ea extends ViewDataBinding {
    @NonNull
    public final LinearLayout bjl;
    @NonNull
    public final ImageView bmW;

    protected ea(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bjl = linearLayout;
        this.bmW = imageView;
    }
}
