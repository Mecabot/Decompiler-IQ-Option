package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: FragmentKycStartNonRegulatedBinding */
public abstract class of extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final wr bxz;
    @NonNull
    public final ImageView byl;

    protected of(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, wr wrVar, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.byl = imageView;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
    }
}
