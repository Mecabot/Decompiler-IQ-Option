package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DepositPageCryptoBinding */
public abstract class gx extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView bpW;
    @NonNull
    public final ImageView bqA;
    @NonNull
    public final LinearLayout bqB;
    @NonNull
    public final TextView bqC;
    @NonNull
    public final RobotoTextView bqD;
    @NonNull
    public final RobotoTextView bqu;
    @NonNull
    public final TextView bqv;
    @NonNull
    public final FrameLayout bqw;
    @NonNull
    public final AppCompatSpinner2 bqx;
    @NonNull
    public final TextView bqy;
    @NonNull
    public final TextView bqz;

    protected gx(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, TextView textView, FrameLayout frameLayout, AppCompatSpinner2 appCompatSpinner2, TextView textView2, TextView textView3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView4, TextView textView5, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.bqu = robotoTextView;
        this.bqv = textView;
        this.bqw = frameLayout;
        this.bqx = appCompatSpinner2;
        this.bqy = textView2;
        this.bqz = textView3;
        this.bpW = imageView;
        this.bqA = imageView2;
        this.bqB = linearLayout;
        this.agA = textView4;
        this.bqC = textView5;
        this.bqD = robotoTextView2;
    }

    @NonNull
    public static gx m(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static gx m(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (gx) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_page_crypto, viewGroup, z, dataBindingComponent);
    }
}
