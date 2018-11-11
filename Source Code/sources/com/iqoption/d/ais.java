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
import com.iqoption.core.ui.widget.MaxSizeLinearLayout;
import com.iqoption.fragment.rightpanel.af.c;
import com.iqoption.view.BuyNewDialogView;
import com.iqoption.view.ConfirmDialogView;
import com.iqoption.view.RobotoTextView;

/* compiled from: RightPanelFxDelegateBinding */
public abstract class ais extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bLU;
    @NonNull
    public final FrameLayout bRh;
    @NonNull
    public final ImageView bRi;
    @NonNull
    public final BuyNewDialogView bRp;
    @NonNull
    public final RobotoTextView bSY;
    @NonNull
    public final RobotoTextView bSZ;
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
    public final LinearLayout bSj;
    @NonNull
    public final TextView bSk;
    @NonNull
    public final TextView bSl;
    @NonNull
    public final LinearLayout bTa;
    @NonNull
    public final MaxSizeLinearLayout bTd;
    @Bindable
    protected c bTe;
    @NonNull
    public final TextView bwO;

    public abstract void a(@Nullable c cVar);

    protected ais(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, ImageView imageView, TextView textView2, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, BuyNewDialogView buyNewDialogView, LinearLayout linearLayout, ConfirmDialogView confirmDialogView, TextView textView3, ConstraintLayout constraintLayout, ImageView imageView2, RobotoTextView robotoTextView3, Guideline guideline, MaxSizeLinearLayout maxSizeLinearLayout, LinearLayout linearLayout2, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.bwO = textView;
        this.bRh = frameLayout;
        this.bRi = imageView;
        this.bSc = textView2;
        this.bSY = robotoTextView;
        this.bSZ = robotoTextView2;
        this.bRp = buyNewDialogView;
        this.bTa = linearLayout;
        this.bSd = confirmDialogView;
        this.bSe = textView3;
        this.bSf = constraintLayout;
        this.bSg = imageView2;
        this.bLU = robotoTextView3;
        this.bSh = guideline;
        this.bTd = maxSizeLinearLayout;
        this.bSj = linearLayout2;
        this.bSk = textView4;
        this.bSl = textView5;
    }
}
