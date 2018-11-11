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

/* compiled from: PortfolioMktOnOpenItemBinding */
public abstract class aff extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout bLL;
    @NonNull
    public final FrameLayout bLN;
    @NonNull
    public final TextView bLZ;
    @NonNull
    public final RobotoTextView bMa;
    @NonNull
    public final afx bPP;
    @NonNull
    public final RobotoTextView bnl;
    @NonNull
    public final ImageView brA;

    protected aff(DataBindingComponent dataBindingComponent, View view, int i, ConstraintLayout constraintLayout, afx afx, RobotoTextView robotoTextView, TextView textView, FrameLayout frameLayout, ImageView imageView, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.bLL = constraintLayout;
        this.bPP = afx;
        setContainedBinding(this.bPP);
        this.bnl = robotoTextView;
        this.bLZ = textView;
        this.bLN = frameLayout;
        this.brA = imageView;
        this.bMa = robotoTextView2;
    }

    @NonNull
    public static aff ar(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ar(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aff ar(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aff) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_mkt_on_open_item, viewGroup, z, dataBindingComponent);
    }
}
