package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: RightPanelDelegateCryptoLoadingBinding */
public abstract class aia extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bRX;

    protected aia(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView) {
        super(dataBindingComponent, view, i);
        this.bRX = formattedTextView;
    }
}
