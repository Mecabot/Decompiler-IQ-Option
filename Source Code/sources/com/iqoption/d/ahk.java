package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;

/* compiled from: RightPanelDelegateCfdBinding */
public abstract class ahk extends ViewDataBinding {
    @NonNull
    public final ahm bQK;
    @NonNull
    public final aho bQL;

    protected ahk(DataBindingComponent dataBindingComponent, View view, int i, ahm ahm, aho aho) {
        super(dataBindingComponent, view, i);
        this.bQK = ahm;
        setContainedBinding(this.bQK);
        this.bQL = aho;
        setContainedBinding(this.bQL);
    }
}
