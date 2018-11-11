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
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: PortfolioPendingGroupItemBinding */
public abstract class aft extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final TextView bLZ;
    @NonNull
    public final ImageView bLq;
    @NonNull
    public final TextView bLr;
    @NonNull
    public final TextView bnL;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final RobotoTextView bnl;

    protected aft(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, RobotoTextView robotoTextView, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bnL = textView;
        this.bLq = imageView2;
        this.bnN = textView2;
        this.bnl = robotoTextView;
        this.bLr = textView3;
        this.bLZ = textView4;
    }

    @NonNull
    public static aft aw(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return aw(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aft aw(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aft) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_pending_group_item, viewGroup, z, dataBindingComponent);
    }
}
