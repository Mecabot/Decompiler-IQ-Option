package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.chat.fragment.MessageView;

/* compiled from: ChatTextMessageHeadItemBinding */
public abstract class es extends ViewDataBinding {
    @NonNull
    public final MessageView bmS;
    @NonNull
    public final TextView bmr;
    @NonNull
    public final LinearLayout bms;

    protected es(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, MessageView messageView) {
        super(dataBindingComponent, view, i);
        this.bmr = textView;
        this.bms = linearLayout;
        this.bmS = messageView;
    }
}
