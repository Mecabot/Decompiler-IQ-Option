package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.fragment.rightpanel.ab.c;
import com.iqoption.view.BuyNewDialogView;
import com.iqoption.view.ConfirmDialogView;
import com.iqoption.view.RobotoTextView;

/* compiled from: RightPanelDelegateDigitalBinding */
public abstract class aig extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bLU;
    @NonNull
    public final FrameLayout bRh;
    @NonNull
    public final ImageView bRi;
    @NonNull
    public final BuyNewDialogView bRp;
    @NonNull
    public final TextView bSc;
    @NonNull
    public final ConfirmDialogView bSd;
    @NonNull
    public final TextView bSe;
    @NonNull
    public final ConstraintLayout bSf;
    @NonNull
    public final ImageView bSg;
    @NonNull
    public final Guideline bSh;
    @NonNull
    public final FrameLayout bSi;
    @NonNull
    public final LinearLayout bSj;
    @NonNull
    public final TextView bSk;
    @NonNull
    public final TextView bSl;
    @Bindable
    protected c bSm;
    @NonNull
    public final TextView bwO;

    public abstract void a(@Nullable c cVar);

    protected aig(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, ImageView imageView, TextView textView2, BuyNewDialogView buyNewDialogView, ConfirmDialogView confirmDialogView, TextView textView3, ConstraintLayout constraintLayout, ImageView imageView2, RobotoTextView robotoTextView, Guideline guideline, FrameLayout frameLayout2, LinearLayout linearLayout, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.bwO = textView;
        this.bRh = frameLayout;
        this.bRi = imageView;
        this.bSc = textView2;
        this.bRp = buyNewDialogView;
        this.bSd = confirmDialogView;
        this.bSe = textView3;
        this.bSf = constraintLayout;
        this.bSg = imageView2;
        this.bLU = robotoTextView;
        this.bSh = guideline;
        this.bSi = frameLayout2;
        this.bSj = linearLayout;
        this.bSk = textView4;
        this.bSl = textView5;
    }
}
