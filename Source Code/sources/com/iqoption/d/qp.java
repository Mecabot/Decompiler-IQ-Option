package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentQuizErrorDelegateBinding */
public abstract class qp extends ViewDataBinding {
    @NonNull
    public final TextView bAU;

    protected qp(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bAU = textView;
    }
}
