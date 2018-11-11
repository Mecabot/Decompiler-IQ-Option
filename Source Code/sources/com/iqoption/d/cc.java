package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeFrameLayout;

/* compiled from: ChatDialogFeedbackBinding */
public abstract class cc extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final FrameLayout awS;
    @NonNull
    public final TextView blE;
    @NonNull
    public final TextView bmc;
    @NonNull
    public final TextInputEditText bmd;
    @NonNull
    public final TextInputLayout bme;
    @NonNull
    public final TextView bmf;
    @NonNull
    public final MaxSizeFrameLayout bmg;
    @NonNull
    public final TextView bmh;

    protected cc(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView3, MaxSizeFrameLayout maxSizeFrameLayout, TextView textView4, FrameLayout frameLayout, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.blE = textView;
        this.bmc = textView2;
        this.bmd = textInputEditText;
        this.bme = textInputLayout;
        this.bmf = textView3;
        this.bmg = maxSizeFrameLayout;
        this.bmh = textView4;
        this.awS = frameLayout;
        this.agA = textView5;
    }
}
