package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.view.text.SoftKeyboardEditText;

/* compiled from: FragmentKycEmailConfirmBinding */
public abstract class mt extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final wr bxz;
    @NonNull
    public final SoftKeyboardEditText byh;
    @NonNull
    public final FormattedTextView byi;

    protected mt(DataBindingComponent dataBindingComponent, View view, int i, SoftKeyboardEditText softKeyboardEditText, FormattedTextView formattedTextView, wr wrVar, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.byh = softKeyboardEditText;
        this.byi = formattedTextView;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
    }
}
