package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: LeftMenuItemSnippetBinding */
public abstract class yc extends ViewDataBinding {
    @NonNull
    public final TextView bKs;

    protected yc(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bKs = textView;
    }
}
