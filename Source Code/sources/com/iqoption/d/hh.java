package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.TextView;

/* compiled from: DepositPaymentSuccessfullyCompletedBinding */
public abstract class hh extends ViewDataBinding {
    @NonNull
    public final TextView boG;
    @NonNull
    public final AppCompatImageView bqU;
    @NonNull
    public final TextView bqV;

    protected hh(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, AppCompatImageView appCompatImageView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.boG = textView;
        this.bqU = appCompatImageView;
        this.bqV = textView2;
    }
}
