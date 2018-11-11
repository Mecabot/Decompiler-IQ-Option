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

/* compiled from: MicroPortfolioPendingSingleGroupItemBinding */
public abstract class aba extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final ConstraintLayout bLL;
    @NonNull
    public final FrameLayout bLN;
    @NonNull
    public final aaw bLY;
    @NonNull
    public final RobotoTextView bMi;
    @NonNull
    public final TextView bnL;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final RobotoTextView bnl;
    @NonNull
    public final ImageView brA;

    protected aba(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, aaw aaw, TextView textView2, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, FrameLayout frameLayout, ImageView imageView2) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bnL = textView;
        this.bLL = constraintLayout;
        this.bLY = aaw;
        setContainedBinding(this.bLY);
        this.bnN = textView2;
        this.bnl = robotoTextView;
        this.bMi = robotoTextView2;
        this.bLN = frameLayout;
        this.brA = imageView2;
    }

    @NonNull
    public static aba af(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return af(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aba af(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aba) DataBindingUtil.inflate(layoutInflater, R.layout.micro_portfolio_pending_single_group_item, viewGroup, z, dataBindingComponent);
    }
}
