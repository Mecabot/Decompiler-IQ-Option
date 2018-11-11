package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.SoftKeyboardEditText;

/* compiled from: FragmentKycQuestionWarning2Binding */
public abstract class np extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final wr bxz;
    @NonNull
    public final TextView byA;
    @NonNull
    public final TextView byB;
    @NonNull
    public final TextView byw;
    @NonNull
    public final TextView byx;
    @NonNull
    public final SoftKeyboardEditText byy;
    @NonNull
    public final RobotoTextView byz;

    protected np(DataBindingComponent dataBindingComponent, View view, int i, wr wrVar, ConfirmButtonView confirmButtonView, TextView textView, TextView textView2, SoftKeyboardEditText softKeyboardEditText, RobotoTextView robotoTextView, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
        this.byw = textView;
        this.byx = textView2;
        this.byy = softKeyboardEditText;
        this.byz = robotoTextView;
        this.byA = textView3;
        this.byB = textView4;
    }
}
