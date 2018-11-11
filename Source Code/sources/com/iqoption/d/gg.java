package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: DepositCurrencyItemBinding */
public abstract class gg extends ViewDataBinding {
    @NonNull
    public final RobotoTextView boY;
    @NonNull
    public final TextView boZ;

    protected gg(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.boY = robotoTextView;
        this.boZ = textView;
    }
}
