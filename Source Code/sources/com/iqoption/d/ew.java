package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.chat.fragment.MessageView;

/* compiled from: ChatTransferDialogMessageItemBinding */
public abstract class ew extends ViewDataBinding {
    @NonNull
    public final MessageView bmS;
    @NonNull
    public final ImageView bmj;
    @NonNull
    public final TextView bmr;
    @NonNull
    public final LinearLayout bms;
    @NonNull
    public final TextView bnd;

    protected ew(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2, MessageView messageView) {
        super(dataBindingComponent, view, i);
        this.bmr = textView;
        this.bmj = imageView;
        this.bms = linearLayout;
        this.bnd = textView2;
        this.bmS = messageView;
    }
}
