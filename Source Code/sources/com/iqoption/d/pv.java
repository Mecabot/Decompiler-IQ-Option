package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentOtnLeadingBoardUserBoardTradingBinding */
public abstract class pv extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final ConstraintLayout bAe;
    @NonNull
    public final TextView bAf;
    @NonNull
    public final TextView bnL;

    protected pv(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bnL = textView;
        this.bAe = constraintLayout;
        this.bAf = textView2;
    }
}
