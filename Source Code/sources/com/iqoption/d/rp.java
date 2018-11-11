package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentQuizPromocodeDelegateBinding */
public abstract class rp extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextInputEditText bBC;
    @NonNull
    public final TextInputLayout bBD;
    @NonNull
    public final TextView bBE;
    @NonNull
    public final TextView bBF;
    @NonNull
    public final TextView bBG;
    @NonNull
    public final TextView bBH;

    protected rp(DataBindingComponent dataBindingComponent, View view, int i, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.bBC = textInputEditText;
        this.bBD = textInputLayout;
        this.bBE = textView;
        this.bBF = textView2;
        this.bBG = textView3;
        this.bBH = textView4;
        this.agA = textView5;
    }
}
