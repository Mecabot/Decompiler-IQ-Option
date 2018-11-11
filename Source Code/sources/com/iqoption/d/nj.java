package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentKycPhoneConfirmedBinding */
public abstract class nj extends ViewDataBinding {
    @NonNull
    public final wp bxE;
    @NonNull
    public final TextView bxU;
    @NonNull
    public final wr bxz;

    protected nj(DataBindingComponent dataBindingComponent, View view, int i, wr wrVar, wp wpVar, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxE = wpVar;
        setContainedBinding(this.bxE);
        this.bxU = textView;
    }
}
