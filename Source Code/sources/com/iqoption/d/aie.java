package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: RightPanelDelegateCryptoSuccessBinding */
public abstract class aie extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bRY;
    @NonNull
    public final TextView bRZ;
    @NonNull
    public final RobotoTextView bSa;
    @NonNull
    public final TextView bSb;

    protected aie(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView, TextView textView, RobotoTextView robotoTextView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bRY = formattedTextView;
        this.bRZ = textView;
        this.bSa = robotoTextView;
        this.bSb = textView2;
    }
}
