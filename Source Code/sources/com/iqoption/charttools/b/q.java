package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: IndicatorConstructorInputFieldBinding */
public abstract class q extends ViewDataBinding {
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final TextView avo;
    @NonNull
    public final EditText avp;

    protected q(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, EditText editText, TextView textView) {
        super(dataBindingComponent, view, i);
        this.avm = linearLayout;
        this.avp = editText;
        this.avo = textView;
    }
}
