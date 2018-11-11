package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: DepositPaymentCompletedPageBinding */
public abstract class hd extends ViewDataBinding {
    @NonNull
    public final TextView boG;
    @NonNull
    public final View boI;
    @NonNull
    public final TextView bqO;
    @NonNull
    public final FrameLayout bqP;
    @NonNull
    public final hh bqQ;
    @NonNull
    public final hj bqR;

    protected hd(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, View view2, FrameLayout frameLayout, hh hhVar, hj hjVar) {
        super(dataBindingComponent, view, i);
        this.boG = textView;
        this.bqO = textView2;
        this.boI = view2;
        this.bqP = frameLayout;
        this.bqQ = hhVar;
        setContainedBinding(this.bqQ);
        this.bqR = hjVar;
        setContainedBinding(this.bqR);
    }
}
