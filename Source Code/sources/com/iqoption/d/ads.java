package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: PortfolioBalanceCashBinding */
public abstract class ads extends ViewDataBinding {
    @NonNull
    public final TextView avo;
    @NonNull
    public final RobotoTextView bOV;
    @NonNull
    public final TextView bOW;
    @NonNull
    public final TextView bOX;
    @NonNull
    public final View bOY;
    @NonNull
    public final FrameLayout bOZ;
    @NonNull
    public final Guideline bPa;
    @NonNull
    public final FrameLayout bPb;
    @NonNull
    public final Guideline bPc;
    @NonNull
    public final TextView bPd;
    @NonNull
    public final FrameLayout bne;
    @NonNull
    public final ProgressBar bng;
    @NonNull
    public final TextView bwQ;

    protected ads(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, TextView textView, FrameLayout frameLayout, TextView textView2, ProgressBar progressBar, TextView textView3, View view2, FrameLayout frameLayout2, Guideline guideline, FrameLayout frameLayout3, Guideline guideline2, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.bOV = robotoTextView;
        this.bwQ = textView;
        this.bne = frameLayout;
        this.bOW = textView2;
        this.bng = progressBar;
        this.bOX = textView3;
        this.bOY = view2;
        this.bOZ = frameLayout2;
        this.bPa = guideline;
        this.bPb = frameLayout3;
        this.bPc = guideline2;
        this.avo = textView4;
        this.bPd = textView5;
    }
}
