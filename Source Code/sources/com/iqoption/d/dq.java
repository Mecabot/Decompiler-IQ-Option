package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.chat.fragment.MessageView;

/* compiled from: ChatLikeDislikeMessageItemBinding */
public abstract class dq extends ViewDataBinding {
    @NonNull
    public final FrameLayout bmO;
    @NonNull
    public final LinearLayout bmP;
    @NonNull
    public final ImageView bmQ;
    @NonNull
    public final ImageView bmR;
    @NonNull
    public final MessageView bmS;
    @NonNull
    public final ImageView bmj;
    @NonNull
    public final TextView bmr;
    @NonNull
    public final LinearLayout bms;

    protected dq(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, ImageView imageView2, ImageView imageView3, MessageView messageView) {
        super(dataBindingComponent, view, i);
        this.bmr = textView;
        this.bmj = imageView;
        this.bms = linearLayout;
        this.bmO = frameLayout;
        this.bmP = linearLayout2;
        this.bmQ = imageView2;
        this.bmR = imageView3;
        this.bmS = messageView;
    }
}
