package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.chat.fragment.MessageView;

/* compiled from: ChatTextMessageBodyItemBinding */
public abstract class eo extends ViewDataBinding {
    @NonNull
    public final MessageView bmS;

    protected eo(DataBindingComponent dataBindingComponent, View view, int i, MessageView messageView) {
        super(dataBindingComponent, view, i);
        this.bmS = messageView;
    }
}
