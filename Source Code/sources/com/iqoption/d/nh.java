package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.view.text.SoftKeyboardEditText;
import com.iqoption.widget.NumPad;

/* compiled from: FragmentKycPhoneConfirmBinding */
public abstract class nh extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final NumPad bxR;
    @NonNull
    public final wr bxz;
    @NonNull
    public final SoftKeyboardEditText byh;
    @NonNull
    public final FormattedTextView byi;
    @NonNull
    public final TextView byt;
    @NonNull
    public final TextView byu;
    @NonNull
    public final TextView byv;

    protected nh(DataBindingComponent dataBindingComponent, View view, int i, SoftKeyboardEditText softKeyboardEditText, FormattedTextView formattedTextView, wr wrVar, ConfirmButtonView confirmButtonView, TextView textView, NumPad numPad, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.byh = softKeyboardEditText;
        this.byi = formattedTextView;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
        this.byt = textView;
        this.bxR = numPad;
        this.byu = textView2;
        this.byv = textView3;
    }
}
