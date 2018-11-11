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
import com.iqoption.x.R;

/* compiled from: PortfolioCfdSingleGroupItemBinding */
public abstract class aee extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView agQ;
    @NonNull
    public final ConstraintLayout bLL;
    @NonNull
    public final FrameLayout bLN;
    @NonNull
    public final aea bPx;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final TextView bns;
    @NonNull
    public final ImageView brA;

    protected aee(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, aea aea, TextView textView, TextView textView2, FrameLayout frameLayout, ImageView imageView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bLL = constraintLayout;
        this.bPx = aea;
        setContainedBinding(this.bPx);
        this.bnN = textView;
        this.agQ = textView2;
        this.bLN = frameLayout;
        this.brA = imageView2;
        this.agA = textView3;
        this.bns = textView4;
    }

    @NonNull
    public static aee am(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return am(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aee am(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aee) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_cfd_single_group_item, viewGroup, z, dataBindingComponent);
    }
}
