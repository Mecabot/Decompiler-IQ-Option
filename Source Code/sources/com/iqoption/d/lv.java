package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: FragmentKycAcceptableDocumentsBinding */
public abstract class lv extends ViewDataBinding {
    @NonNull
    public final LinearLayout bxy;
    @NonNull
    public final wr bxz;

    protected lv(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, wr wrVar) {
        super(dataBindingComponent, view, i);
        this.bxy = linearLayout;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
    }
}
