package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: FragmentKycDocumentAddressBinding */
public abstract class ml extends ViewDataBinding {
    @NonNull
    public final TextView bxF;
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final LinearLayout bxS;
    @NonNull
    public final TextView bxT;
    @NonNull
    public final wr bxz;

    protected ml(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, wr wrVar, ConfirmButtonView confirmButtonView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bxF = textView;
        this.bxS = linearLayout;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxH = confirmButtonView;
        this.bxT = textView2;
    }
}
