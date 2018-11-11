package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentKycQuestionMultiChoiceBinding */
public abstract class nl extends ViewDataBinding {
    @NonNull
    public final wp bxE;
    @NonNull
    public final LinearLayout bxS;
    @NonNull
    public final TextView bxT;
    @NonNull
    public final wr bxz;

    protected nl(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, wr wrVar, wp wpVar, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bxS = linearLayout;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxE = wpVar;
        setContainedBinding(this.bxE);
        this.bxT = textView;
    }
}
