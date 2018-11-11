package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.iqoption.view.rounded.RoundedFrameLayout;

/* compiled from: FragmentDepositMethodsOldBinding */
public abstract class lq extends ViewDataBinding {
    @NonNull
    public final RoundedFrameLayout bxo;
    @NonNull
    public final RecyclerView bxp;

    protected lq(DataBindingComponent dataBindingComponent, View view, int i, RoundedFrameLayout roundedFrameLayout, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bxo = roundedFrameLayout;
        this.bxp = recyclerView;
    }
}
