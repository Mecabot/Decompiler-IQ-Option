package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import com.iqoption.view.RobotoTextView;

/* compiled from: PortfolioBalancesBinding */
public abstract class adw extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bPr;
    @NonNull
    public final LinearLayout bPs;
    @NonNull
    public final ads bPt;
    @NonNull
    public final adu bPu;
    @NonNull
    public final RobotoTextView bPv;

    protected adw(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, LinearLayout linearLayout, ads ads, adu adu, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.bPr = robotoTextView;
        this.bPs = linearLayout;
        this.bPt = ads;
        setContainedBinding(this.bPt);
        this.bPu = adu;
        setContainedBinding(this.bPu);
        this.bPv = robotoTextView2;
    }
}
