package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.text.SoftKeyboardEditText;

/* compiled from: FragmentKycLegalNameBinding */
public abstract class nd extends ViewDataBinding {
    @NonNull
    public final wp bxE;
    @NonNull
    public final TextView bxQ;
    @NonNull
    public final wr bxz;
    @NonNull
    public final SoftKeyboardEditText byr;
    @NonNull
    public final SoftKeyboardEditText bys;

    protected nd(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, SoftKeyboardEditText softKeyboardEditText, wr wrVar, SoftKeyboardEditText softKeyboardEditText2, wp wpVar) {
        super(dataBindingComponent, view, i);
        this.bxQ = textView;
        this.byr = softKeyboardEditText;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bys = softKeyboardEditText2;
        this.bxE = wpVar;
        setContainedBinding(this.bxE);
    }
}
