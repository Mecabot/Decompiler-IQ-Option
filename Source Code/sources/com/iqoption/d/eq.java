package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.chat.fragment.MessageView;

/* compiled from: ChatTextMessageFullItemBinding */
public abstract class eq extends ViewDataBinding {
    @NonNull
    public final MessageView bmS;
    @NonNull
    public final ImageView bmj;
    @NonNull
    public final TextView bmr;
    @NonNull
    public final LinearLayout bms;

    protected eq(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, MessageView messageView) {
        super(dataBindingComponent, view, i);
        this.bmr = textView;
        this.bmj = imageView;
        this.bms = linearLayout;
        this.bmS = messageView;
    }
}
