package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: PortfolioExpInfoBinding */
public abstract class aer extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bDY;
    @NonNull
    public final LinearLayout bDZ;
    @NonNull
    public final RobotoTextView bEb;
    @NonNull
    public final LinearLayout bEc;
    @NonNull
    public final FrameLayout bLP;
    @NonNull
    public final TextView bLQ;
    @NonNull
    public final ProgressBar bLR;
    @NonNull
    public final LinearLayout bLS;
    @NonNull
    public final RobotoTextView bLT;
    @NonNull
    public final RobotoTextView bLU;
    @NonNull
    public final RobotoTextView bLW;
    @NonNull
    public final RobotoTextView bLw;
    @NonNull
    public final RobotoTextView brp;

    protected aer(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, ProgressBar progressBar, RobotoTextView robotoTextView, LinearLayout linearLayout, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5, LinearLayout linearLayout2, RobotoTextView robotoTextView6, RobotoTextView robotoTextView7, LinearLayout linearLayout3) {
        super(dataBindingComponent, view, i);
        this.bLP = frameLayout;
        this.bLQ = textView;
        this.bLR = progressBar;
        this.bLw = robotoTextView;
        this.bLS = linearLayout;
        this.bLT = robotoTextView2;
        this.bLU = robotoTextView3;
        this.brp = robotoTextView4;
        this.bDY = robotoTextView5;
        this.bDZ = linearLayout2;
        this.bLW = robotoTextView6;
        this.bEb = robotoTextView7;
        this.bEc = linearLayout3;
    }
}
