package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.RobotoTextView;

/* compiled from: StrikeItemBinding */
public abstract class ajs extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bHO;
    @NonNull
    public final RobotoTextView bHP;
    @NonNull
    public final RobotoTextView bHQ;
    @NonNull
    public final RobotoTextView bTA;
    @NonNull
    public final RobotoTextView bTB;

    protected ajs(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5) {
        super(dataBindingComponent, view, i);
        this.bHO = robotoTextView;
        this.bTA = robotoTextView2;
        this.bHP = robotoTextView3;
        this.bTB = robotoTextView4;
        this.bHQ = robotoTextView5;
    }
}
