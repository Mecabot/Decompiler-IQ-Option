package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentKycSexBinding */
public abstract class od extends ViewDataBinding {
    @NonNull
    public final TextView bxQ;
    @NonNull
    public final wr bxz;
    @NonNull
    public final TextView byJ;
    @NonNull
    public final TextView byK;

    protected od(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, wr wrVar, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bxQ = textView;
        this.byJ = textView2;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.byK = textView3;
    }
}
