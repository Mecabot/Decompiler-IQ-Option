package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.SoftKeyboardEditText;
import com.iqoption.widget.NumPad;

/* compiled from: FragmentKycPhoneBinding */
public abstract class nf extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final SoftKeyboardEditText bif;
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final NumPad bxR;
    @NonNull
    public final wr bxz;

    protected nf(DataBindingComponent dataBindingComponent, View view, int i, wr wrVar, ConfirmButtonView confirmButtonView, NumPad numPad, SoftKeyboardEditText softKeyboardEditText, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
        this.bxR = numPad;
        this.bif = softKeyboardEditText;
        this.agA = textView;
    }
}
