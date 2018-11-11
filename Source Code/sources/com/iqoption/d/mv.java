package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.RobotoTextView;

/* compiled from: FragmentKycEmailConfirmedBinding */
public abstract class mv extends ViewDataBinding {
    @NonNull
    public final wp bxE;
    @NonNull
    public final wr bxz;
    @NonNull
    public final RobotoTextView byj;

    protected mv(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, wr wrVar, wp wpVar) {
        super(dataBindingComponent, view, i);
        this.byj = robotoTextView;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxE = wpVar;
        setContainedBinding(this.bxE);
    }
}
