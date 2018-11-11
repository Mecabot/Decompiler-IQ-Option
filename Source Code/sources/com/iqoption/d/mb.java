package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: FragmentKycBlockBinding */
public abstract class mb extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxI;
    @NonNull
    public final wr bxz;

    protected mb(DataBindingComponent dataBindingComponent, View view, int i, wr wrVar, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxI = confirmButtonView;
    }
}
