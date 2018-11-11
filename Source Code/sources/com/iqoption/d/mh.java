package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: FragmentKycCysecBinding */
public abstract class mh extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final wr bxz;

    protected mh(DataBindingComponent dataBindingComponent, View view, int i, wr wrVar, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
    }
}
