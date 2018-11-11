package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.SwitchCompat;
import android.view.View;

/* compiled from: IndicatorConstructorInputBoolBinding */
public abstract class m extends ViewDataBinding {
    @NonNull
    public final SwitchCompat axA;

    protected m(DataBindingComponent dataBindingComponent, View view, int i, SwitchCompat switchCompat) {
        super(dataBindingComponent, view, i);
        this.axA = switchCompat;
    }
}
