package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: FragmentKycReportableBinding */
public abstract class nx extends ViewDataBinding {
    @NonNull
    public final TextView axy;
    @NonNull
    public final wr bxz;
    @NonNull
    public final ConfirmButtonView byF;
    @NonNull
    public final TextView byG;
    @NonNull
    public final ConfirmButtonView byH;

    protected nx(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, wr wrVar, ConfirmButtonView confirmButtonView, TextView textView2, ConfirmButtonView confirmButtonView2) {
        super(dataBindingComponent, view, i);
        this.axy = textView;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.byF = confirmButtonView;
        this.byG = textView2;
        this.byH = confirmButtonView2;
    }
}
