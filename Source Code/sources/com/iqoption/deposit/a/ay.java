package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: ItemPresetWithBadgeBinding */
public abstract class ay extends ViewDataBinding {
    @NonNull
    public final cc bZL;
    @NonNull
    public final TextView bZP;

    protected ay(DataBindingComponent dataBindingComponent, View view, int i, cc ccVar, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bZL = ccVar;
        setContainedBinding(this.bZL);
        this.bZP = textView;
    }
}
