package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: FragmentKycQuestionYesNoBinding */
public abstract class nt extends ViewDataBinding {
    @NonNull
    public final TextView bxT;
    @NonNull
    public final wr bxz;
    @NonNull
    public final RobotoTextView byC;
    @NonNull
    public final RobotoTextView byD;

    protected nt(DataBindingComponent dataBindingComponent, View view, int i, wr wrVar, RobotoTextView robotoTextView, TextView textView, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.byC = robotoTextView;
        this.bxT = textView;
        this.byD = robotoTextView2;
    }
}
