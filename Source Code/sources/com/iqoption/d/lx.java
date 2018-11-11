package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.text.SoftKeyboardEditText;

/* compiled from: FragmentKycAddressBinding */
public abstract class lx extends ViewDataBinding {
    @NonNull
    public final SoftKeyboardEditText bxB;
    @NonNull
    public final SoftKeyboardEditText bxC;
    @NonNull
    public final TextView bxD;
    @NonNull
    public final wp bxE;
    @NonNull
    public final wr bxz;

    protected lx(DataBindingComponent dataBindingComponent, View view, int i, SoftKeyboardEditText softKeyboardEditText, SoftKeyboardEditText softKeyboardEditText2, TextView textView, wr wrVar, wp wpVar) {
        super(dataBindingComponent, view, i);
        this.bxB = softKeyboardEditText;
        this.bxC = softKeyboardEditText2;
        this.bxD = textView;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxE = wpVar;
        setContainedBinding(this.bxE);
    }
}
