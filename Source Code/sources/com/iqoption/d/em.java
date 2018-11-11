package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: ChatSuggestionMessageItemBinding */
public abstract class em extends ViewDataBinding {
    @NonNull
    public final TextView bnc;

    protected em(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bnc = textView;
    }
}
