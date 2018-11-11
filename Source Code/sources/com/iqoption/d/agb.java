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

/* compiled from: PortfolioPendingSingleGroupItemBinding */
public abstract class agb extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final ConstraintLayout bLL;
    @NonNull
    public final FrameLayout bLN;
    @NonNull
    public final TextView bLZ;
    @NonNull
    public final RobotoTextView bMi;
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

    protected agb(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, afx afx, TextView textView2, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, TextView textView3, FrameLayout frameLayout, ImageView imageView2) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bnL = textView;
        this.bLL = constraintLayout;
        this.bPP = afx;
        setContainedBinding(this.bPP);
        this.bnN = textView2;
        this.bnl = robotoTextView;
        this.bMi = robotoTextView2;
        this.bLZ = textView3;
        this.bLN = frameLayout;
        this.brA = imageView2;
    }

    @NonNull
    public static agb az(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return az(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static agb az(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (agb) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_pending_single_group_item, viewGroup, z, dataBindingComponent);
    }
}
