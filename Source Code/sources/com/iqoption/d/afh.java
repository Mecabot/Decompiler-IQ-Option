package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: PortfolioMktOnOpenSingleGroupItemBinding */
public abstract class afh extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final ConstraintLayout bLL;
    @NonNull
    public final FrameLayout bLN;
    @NonNull
    public final RobotoTextView bMa;
    @NonNull
    public final afx bPP;
    @NonNull
    public final TextView bnL;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final RobotoTextView bnl;
    @NonNull
    public final ImageView brA;

    protected afh(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, afx afx, TextView textView2, RobotoTextView robotoTextView, FrameLayout frameLayout, ImageView imageView2, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bnL = textView;
        this.bLL = constraintLayout;
        this.bPP = afx;
        setContainedBinding(this.bPP);
        this.bnN = textView2;
        this.bnl = robotoTextView;
        this.bLN = frameLayout;
        this.brA = imageView2;
        this.bMa = robotoTextView2;
    }

    @NonNull
    public static afh as(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return as(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static afh as(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (afh) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_mkt_on_open_single_group_item, viewGroup, z, dataBindingComponent);
    }
}
