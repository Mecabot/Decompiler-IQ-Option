package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: FragmentKycQuestionWarningBinding */
public abstract class nr extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final wr bxz;
    @NonNull
    public final TextView byB;
    @NonNull
    public final TextView byw;

    protected nr(DataBindingComponent dataBindingComponent, View view, int i, wr wrVar, ConfirmButtonView confirmButtonView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
        this.byw = textView;
        this.byB = textView2;
    }
}
