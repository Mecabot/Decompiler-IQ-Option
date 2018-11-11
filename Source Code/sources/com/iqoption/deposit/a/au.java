package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;

/* compiled from: ItemPresetBinding */
public abstract class au extends ViewDataBinding {
    @NonNull
    public final cc bZL;

    protected au(DataBindingComponent dataBindingComponent, View view, int i, cc ccVar) {
        super(dataBindingComponent, view, i);
        this.bZL = ccVar;
        setContainedBinding(this.bZL);
    }
}
