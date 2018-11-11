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
import com.iqoption.x.R;

/* compiled from: DepositCryptoPaymentMethodItemBinding */
public abstract class ge extends ViewDataBinding {
    @NonNull
    public final TextView aig;
    @NonNull
    public final ImageView bmu;

    protected ge(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bmu = imageView;
        this.aig = textView;
    }

    @NonNull
    public static ge j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ge j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (ge) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_crypto_payment_method_item, viewGroup, z, dataBindingComponent);
    }
}
