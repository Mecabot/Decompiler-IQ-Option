package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: RightPanelDelegateTurboBinaryCallPutBinding */
public abstract class aiq extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bEa;
    @NonNull
    public final RobotoTextView bSY;
    @NonNull
    public final RobotoTextView bSZ;
    @NonNull
    public final LinearLayout bTa;
    @NonNull
    public final TextView bTb;
    @NonNull
    public final TextView bTc;

    protected aiq(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, LinearLayout linearLayout, TextView textView, TextView textView2, RobotoTextView robotoTextView3) {
        super(dataBindingComponent, view, i);
        this.bSY = robotoTextView;
        this.bSZ = robotoTextView2;
        this.bTa = linearLayout;
        this.bTb = textView;
        this.bTc = textView2;
        this.bEa = robotoTextView3;
    }
}
