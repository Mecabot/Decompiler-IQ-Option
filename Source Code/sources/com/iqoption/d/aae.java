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

/* compiled from: MicroPortfolioMktOnOpenItemBinding */
public abstract class aae extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout bLL;
    @NonNull
    public final FrameLayout bLN;
    @NonNull
    public final aaw bLY;
    @NonNull
    public final TextView bLZ;
    @NonNull
    public final RobotoTextView bMa;
    @NonNull
    public final RobotoTextView bnl;
    @NonNull
    public final ImageView brA;

    protected aae(DataBindingComponent dataBindingComponent, View view, int i, ConstraintLayout constraintLayout, aaw aaw, RobotoTextView robotoTextView, TextView textView, FrameLayout frameLayout, ImageView imageView, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.bLL = constraintLayout;
        this.bLY = aaw;
        setContainedBinding(this.bLY);
        this.bnl = robotoTextView;
        this.bLZ = textView;
        this.bLN = frameLayout;
        this.brA = imageView;
        this.bMa = robotoTextView2;
    }

    @NonNull
    public static aae Y(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return Y(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aae Y(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aae) DataBindingUtil.inflate(layoutInflater, R.layout.micro_portfolio_mkt_on_open_item, viewGroup, z, dataBindingComponent);
    }
}
