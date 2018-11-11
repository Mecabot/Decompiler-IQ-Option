package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.chat.fragment.MessageView;

/* compiled from: ChatTextMessageTailItemBinding */
public abstract class eu extends ViewDataBinding {
    @NonNull
    public final MessageView bmS;
    @NonNull
    public final ImageView bmj;
    @NonNull
    public final LinearLayout bms;

    protected eu(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, MessageView messageView) {
        super(dataBindingComponent, view, i);
        this.bmj = imageView;
        this.bms = linearLayout;
        this.bmS = messageView;
    }
}
