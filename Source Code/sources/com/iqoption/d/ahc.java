package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.a.r.a;

/* compiled from: PushSettingsCategoryItemBinding */
public abstract class ahc extends ViewDataBinding {
    @NonNull
    public final TextView bQs;
    @Bindable
    protected a bQt;

    protected ahc(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bQs = textView;
    }
}
