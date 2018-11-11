package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: FragmentPendingOrderExecutedBinding */
public abstract class qb extends ViewDataBinding {
    @NonNull
    public final TextView bAu;
    @NonNull
    public final TextView bAv;
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final TextView brN;
    @NonNull
    public final FrameLayout bxe;
    @NonNull
    public final LinearLayout bxi;
    @NonNull
    public final TextView bxj;
    @NonNull
    public final View byZ;
    @NonNull
    public final RobotoTextView bza;

    protected qb(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, TextView textView2, View view2, FrameLayout frameLayout2, LinearLayout linearLayout, TextView textView3, TextView textView4, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bAu = textView;
        this.bxe = frameLayout;
        this.brN = textView2;
        this.byZ = view2;
        this.blV = frameLayout2;
        this.bxi = linearLayout;
        this.bxj = textView3;
        this.bAv = textView4;
        this.bza = robotoTextView;
    }
}
