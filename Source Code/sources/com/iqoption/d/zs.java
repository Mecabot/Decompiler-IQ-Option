package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: MicroPortfolioClosedItemBinding */
public abstract class zs extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final TextView agQ;
    @NonNull
    public final LinearLayout bjl;
    @NonNull
    public final TextView bnM;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final TextView brz;
    @NonNull
    public final RobotoTextView btN;

    protected zs(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RobotoTextView robotoTextView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.btN = robotoTextView;
        this.bjl = linearLayout;
        this.bnM = textView;
        this.bnN = textView2;
        this.agQ = textView3;
        this.brz = textView4;
    }

    @NonNull
    public static zs T(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return T(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static zs T(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (zs) DataBindingUtil.inflate(layoutInflater, R.layout.micro_portfolio_closed_item, viewGroup, z, dataBindingComponent);
    }
}
