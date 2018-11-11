package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentQuizUpdateDelegateBinding */
public abstract class rv extends ViewDataBinding {
    @NonNull
    public final TextView bBK;
    @NonNull
    public final TextView bBL;
    @NonNull
    public final TextView bBl;
    @NonNull
    public final TextView bBm;
    @NonNull
    public final TextView bBn;
    @NonNull
    public final TextView bBo;
    @NonNull
    public final TextView bBp;
    @NonNull
    public final rl bBq;

    protected rv(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, rl rlVar, TextView textView7) {
        super(dataBindingComponent, view, i);
        this.bBK = textView;
        this.bBl = textView2;
        this.bBm = textView3;
        this.bBn = textView4;
        this.bBo = textView5;
        this.bBp = textView6;
        this.bBq = rlVar;
        setContainedBinding(this.bBq);
        this.bBL = textView7;
    }
}
