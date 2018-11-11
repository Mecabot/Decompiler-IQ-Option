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
import com.iqoption.core.ui.widget.StarBar;

/* compiled from: ChatRateMessageItemBinding */
public abstract class dy extends ViewDataBinding {
    @NonNull
    public final FrameLayout bmO;
    @NonNull
    public final MessageView bmS;
    @NonNull
    public final StarBar bmT;
    @NonNull
    public final MessageView bmU;
    @NonNull
    public final FrameLayout bmV;
    @NonNull
    public final ImageView bmj;
    @NonNull
    public final TextView bmr;
    @NonNull
    public final LinearLayout bms;

    protected dy(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, FrameLayout frameLayout, MessageView messageView, StarBar starBar, MessageView messageView2, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.bmr = textView;
        this.bmj = imageView;
        this.bms = linearLayout;
        this.bmO = frameLayout;
        this.bmS = messageView;
        this.bmT = starBar;
        this.bmU = messageView2;
        this.bmV = frameLayout2;
    }
}
