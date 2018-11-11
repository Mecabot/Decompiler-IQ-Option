package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: PortfolioTitleBinding */
public abstract class agd extends ViewDataBinding {
    @NonNull
    public final TextView avo;
    @NonNull
    public final RobotoTextView bHQ;

    protected agd(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.avo = textView;
        this.bHQ = robotoTextView;
    }
}
