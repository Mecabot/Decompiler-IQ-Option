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

/* compiled from: MicroPortfolioCfdSingleGroupItemBinding */
public abstract class zo extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final TextView agQ;
    @NonNull
    public final ConstraintLayout bLL;
    @NonNull
    public final zk bLM;
    @NonNull
    public final FrameLayout bLN;
    @NonNull
    public final TextView bnL;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final TextView bns;
    @NonNull
    public final ImageView brA;

    protected zo(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, zk zkVar, TextView textView2, TextView textView3, FrameLayout frameLayout, ImageView imageView2, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bnL = textView;
        this.bLL = constraintLayout;
        this.bLM = zkVar;
        setContainedBinding(this.bLM);
        this.bnN = textView2;
        this.agQ = textView3;
        this.bLN = frameLayout;
        this.brA = imageView2;
        this.bns = textView4;
    }

    @NonNull
    public static zo R(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return R(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static zo R(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (zo) DataBindingUtil.inflate(layoutInflater, R.layout.micro_portfolio_cfd_single_group_item, viewGroup, z, dataBindingComponent);
    }
}
