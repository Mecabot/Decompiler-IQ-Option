package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: LayoutWelcomeSocialBinding */
public abstract class xf extends ViewDataBinding {
    @NonNull
    public final LinearLayout bKo;
    @NonNull
    public final LinearLayout bKp;
    @NonNull
    public final LinearLayout bKq;
    @NonNull
    public final TextView bKr;

    protected xf(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bKo = linearLayout;
        this.bKp = linearLayout2;
        this.bKq = linearLayout3;
        this.bKr = textView;
    }
}
