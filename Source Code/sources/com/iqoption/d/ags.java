package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: PriceMovementsHighFrequecyItemBinding */
public abstract class ags extends ViewDataBinding {
    @NonNull
    public final TextView bHW;
    @NonNull
    public final RobotoTextView bQe;

    protected ags(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bHW = textView;
        this.bQe = robotoTextView;
    }
}
