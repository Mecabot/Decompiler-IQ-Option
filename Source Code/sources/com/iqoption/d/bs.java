package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: BuyNewDialogViewBinding */
public abstract class bs extends ViewDataBinding {
    @NonNull
    public final RobotoTextView blK;
    @NonNull
    public final TextView blL;

    protected bs(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.blK = robotoTextView;
        this.blL = textView;
    }
}
