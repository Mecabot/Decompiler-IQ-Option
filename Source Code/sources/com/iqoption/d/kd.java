package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.widget.DialpadDot;

/* compiled from: DialpadDotBinding */
public abstract class kd extends ViewDataBinding {
    @NonNull
    public final DialpadDot bvc;

    protected kd(DataBindingComponent dataBindingComponent, View view, int i, DialpadDot dialpadDot) {
        super(dataBindingComponent, view, i);
        this.bvc = dialpadDot;
    }
}
