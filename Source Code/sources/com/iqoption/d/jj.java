package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: DialogProTraderBenefitsBinding */
public abstract class jj extends ViewDataBinding {
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final TextView btu;
    @NonNull
    public final wx btv;
    @NonNull
    public final LinearLayout btw;
    @NonNull
    public final wv btx;
    @NonNull
    public final wz bty;

    protected jj(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, wx wxVar, LinearLayout linearLayout, wv wvVar, wz wzVar) {
        super(dataBindingComponent, view, i);
        this.bjF = frameLayout;
        this.btu = textView;
        this.btv = wxVar;
        setContainedBinding(this.btv);
        this.btw = linearLayout;
        this.btx = wvVar;
        setContainedBinding(this.btx);
        this.bty = wzVar;
        setContainedBinding(this.bty);
    }
}
