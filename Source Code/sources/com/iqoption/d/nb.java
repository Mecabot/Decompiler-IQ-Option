package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: FragmentKycIdDeclinedBinding */
public abstract class nb extends ViewDataBinding {
    @NonNull
    public final TextView bxF;
    @NonNull
    public final TextView bxG;
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final wr bxz;

    protected nb(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, wr wrVar, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.bxF = textView;
        this.bxG = textView2;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
    }
}
