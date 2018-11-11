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

/* compiled from: PortfolioPendingItemBinding */
public abstract class afz extends ViewDataBinding {
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
    public final RobotoTextView bnl;
    @NonNull
    public final ImageView brA;

    protected afz(DataBindingComponent dataBindingComponent, View view, int i, ConstraintLayout constraintLayout, afx afx, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, TextView textView, FrameLayout frameLayout, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bLL = constraintLayout;
        this.bPP = afx;
        setContainedBinding(this.bPP);
        this.bnl = robotoTextView;
        this.bMi = robotoTextView2;
        this.bLZ = textView;
        this.bLN = frameLayout;
        this.brA = imageView;
    }

    @NonNull
    public static afz ay(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ay(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static afz ay(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (afz) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_pending_item, viewGroup, z, dataBindingComponent);
    }
}
