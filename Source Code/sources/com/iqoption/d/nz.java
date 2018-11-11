package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: FragmentKycReportableErrorBinding */
public abstract class nz extends ViewDataBinding {
    @NonNull
    public final wr bxz;
    @NonNull
    public final FormattedTextView byI;

    protected nz(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView, wr wrVar) {
        super(dataBindingComponent, view, i);
        this.byI = formattedTextView;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
    }
}
