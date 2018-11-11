package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.RobotoTextView;

/* compiled from: FxStrikeItemBinding */
public abstract class vf extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bHO;
    @NonNull
    public final RobotoTextView bHP;
    @NonNull
    public final RobotoTextView bHQ;

    protected vf(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3) {
        super(dataBindingComponent, view, i);
        this.bHO = robotoTextView;
        this.bHP = robotoTextView2;
        this.bHQ = robotoTextView3;
    }
}
