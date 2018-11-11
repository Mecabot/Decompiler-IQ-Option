package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: PositionItemTitleLayoutBinding */
public abstract class agg extends ViewDataBinding {
    @NonNull
    public final TextView bPS;

    protected agg(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bPS = textView;
    }
}
