package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: FragmentBalanceBarBinding */
public abstract class lh extends ViewDataBinding {
    @NonNull
    public final TextView bwO;
    @NonNull
    public final RobotoTextView bwP;
    @NonNull
    public final TextView bwQ;

    protected lh(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, RobotoTextView robotoTextView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bwO = textView;
        this.bwP = robotoTextView;
        this.bwQ = textView2;
    }
}
