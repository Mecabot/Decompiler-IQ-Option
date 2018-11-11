package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: OvernightFeeItemBinding */
public abstract class adc extends ViewDataBinding {
    @NonNull
    public final TextView bAu;
    @NonNull
    public final TextView bNU;
    @NonNull
    public final RobotoTextView blC;

    protected adc(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bAu = textView;
        this.bNU = textView2;
        this.blC = robotoTextView;
    }

    @NonNull
    public static adc ah(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ah(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static adc ah(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (adc) DataBindingUtil.inflate(layoutInflater, R.layout.overnight_fee_item, viewGroup, z, dataBindingComponent);
    }
}
