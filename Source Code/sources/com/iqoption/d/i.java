package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: AccountSecurityConfirmedEmailFragmentBinding */
public abstract class i extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bhX;
    @NonNull
    public final FormattedTextView bhY;

    protected i(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView, FormattedTextView formattedTextView2) {
        super(dataBindingComponent, view, i);
        this.bhX = formattedTextView;
        this.bhY = formattedTextView2;
    }
}
