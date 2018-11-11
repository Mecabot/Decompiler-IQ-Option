package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.chat.fragment.MessageView;

/* compiled from: ChatUserTextMessageItemBinding */
public abstract class fc extends ViewDataBinding {
    @NonNull
    public final MessageView bmS;

    protected fc(DataBindingComponent dataBindingComponent, View view, int i, MessageView messageView) {
        super(dataBindingComponent, view, i);
        this.bmS = messageView;
    }
}
