package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* compiled from: ChatRoomSendLayoutBinding */
public abstract class eh extends ViewDataBinding {
    @NonNull
    public final LinearLayout bjl;
    @NonNull
    public final ImageView bmG;
    @NonNull
    public final ImageView bmX;
    @NonNull
    public final EditText bmY;

    protected eh(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, EditText editText) {
        super(dataBindingComponent, view, i);
        this.bmX = imageView;
        this.bmG = imageView2;
        this.bjl = linearLayout;
        this.bmY = editText;
    }
}
