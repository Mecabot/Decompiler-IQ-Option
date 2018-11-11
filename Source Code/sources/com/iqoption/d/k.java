package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: AccountSecurityConfirmedPhoneFragmentBinding */
public abstract class k extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bhY;
    @NonNull
    public final FormattedTextView bhZ;

    protected k(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView, FormattedTextView formattedTextView2) {
        super(dataBindingComponent, view, i);
        this.bhZ = formattedTextView;
        this.bhY = formattedTextView2;
    }
}
