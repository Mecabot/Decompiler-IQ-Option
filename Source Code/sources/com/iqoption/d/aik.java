package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;

/* compiled from: RightPanelDelegateOnOpenCfdBinding */
public abstract class aik extends ViewDataBinding {
    @NonNull
    public final ahq bSK;
    @NonNull
    public final ahs bSL;

    protected aik(DataBindingComponent dataBindingComponent, View view, int i, ahq ahq, ahs ahs) {
        super(dataBindingComponent, view, i);
        this.bSK = ahq;
        setContainedBinding(this.bSK);
        this.bSL = ahs;
        setContainedBinding(this.bSL);
    }
}
