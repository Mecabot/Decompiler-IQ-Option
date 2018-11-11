package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

/* compiled from: OperationHistorySingleSelectionBinding */
public abstract class aco extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final RadioButton bNN;

    protected aco(DataBindingComponent dataBindingComponent, View view, int i, RadioButton radioButton, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bNN = radioButton;
        this.agA = textView;
    }
}
