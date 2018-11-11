package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.TextView;

/* compiled from: NewsAndUpdatesItemBinding */
public abstract class abm extends ViewDataBinding {
    @NonNull
    public final TextView bMo;
    @NonNull
    public final SwitchCompat bMp;
    @NonNull
    public final TextView bMq;

    protected abm(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, SwitchCompat switchCompat, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bMo = textView;
        this.bMp = switchCompat;
        this.bMq = textView2;
    }
}
