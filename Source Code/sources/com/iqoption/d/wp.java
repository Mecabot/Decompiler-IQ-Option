package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: KycContinueButtonBinding */
public abstract class wp extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxH;

    protected wp(DataBindingComponent dataBindingComponent, View view, int i, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.bxH = confirmButtonView;
    }
}
