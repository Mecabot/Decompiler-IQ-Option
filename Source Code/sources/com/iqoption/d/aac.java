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
import com.iqoption.view.timer.TimerView;
import com.iqoption.x.R;

/* compiled from: MicroPortfolioExpSingleGroupItemBinding */
public abstract class aac extends ViewDataBinding {
    @NonNull
    public final TextView agQ;
    @NonNull
    public final ConstraintLayout bLL;
    @NonNull
    public final FrameLayout bLN;
    @NonNull
    public final zy bLX;
    @NonNull
    public final TimerView blb;
    @NonNull
    public final TextView bnL;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final TextView bns;
    @NonNull
    public final ImageView brA;

    protected aac(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ConstraintLayout constraintLayout, zy zyVar, TextView textView2, TextView textView3, FrameLayout frameLayout, ImageView imageView, TimerView timerView, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bnL = textView;
        this.bLL = constraintLayout;
        this.bLX = zyVar;
        setContainedBinding(this.bLX);
        this.bnN = textView2;
        this.agQ = textView3;
        this.bLN = frameLayout;
        this.brA = imageView;
        this.blb = timerView;
        this.bns = textView4;
    }

    @NonNull
    public static aac X(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return X(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aac X(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aac) DataBindingUtil.inflate(layoutInflater, R.layout.micro_portfolio_exp_single_group_item, viewGroup, z, dataBindingComponent);
    }
}
