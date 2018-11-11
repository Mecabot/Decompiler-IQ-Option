package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.a.p.d;

/* compiled from: PriceMovementsProgressBinding */
public abstract class agy extends ViewDataBinding {
    @NonNull
    public final FrameLayout bQp;
    @Bindable
    protected d bQq;

    protected agy(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.bQp = frameLayout;
    }
}
