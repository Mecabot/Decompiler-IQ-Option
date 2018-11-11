package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.SoftKeyboardEditText;
import com.iqoption.widget.NumPad;

/* compiled from: FragmentKycDateOfBirthBinding */
public abstract class mj extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final SoftKeyboardEditText bxP;
    @NonNull
    public final TextView bxQ;
    @NonNull
    public final NumPad bxR;
    @NonNull
    public final wr bxz;

    protected mj(DataBindingComponent dataBindingComponent, View view, int i, SoftKeyboardEditText softKeyboardEditText, TextView textView, wr wrVar, ConfirmButtonView confirmButtonView, NumPad numPad) {
        super(dataBindingComponent, view, i);
        this.bxP = softKeyboardEditText;
        this.bxQ = textView;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
        this.bxR = numPad;
    }
}
