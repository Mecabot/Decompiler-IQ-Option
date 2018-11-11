package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: FragmentDepositBinding */
public abstract class m extends ViewDataBinding {
    @NonNull
    public final bm bYP;
    @NonNull
    public final TextView bYQ;
    @NonNull
    public final FrameLayout bYR;
    @NonNull
    public final bs bYS;

    protected m(DataBindingComponent dataBindingComponent, View view, int i, bm bmVar, TextView textView, FrameLayout frameLayout, bs bsVar) {
        super(dataBindingComponent, view, i);
        this.bYP = bmVar;
        setContainedBinding(this.bYP);
        this.bYQ = textView;
        this.bYR = frameLayout;
        this.bYS = bsVar;
        setContainedBinding(this.bYS);
    }
}
