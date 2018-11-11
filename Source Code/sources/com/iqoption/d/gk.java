package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner2;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.fragment.cashbox.AmountFrameViewSwitcher;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: DepositOldAmountLineBinding */
public abstract class gk extends ViewDataBinding {
    @NonNull
    public final AmountFrameViewSwitcher bpg;
    @NonNull
    public final TextView bph;
    @NonNull
    public final ImageView bpi;
    @NonNull
    public final AppCompatSpinner2 bpj;
    @NonNull
    public final TextView bpk;
    @NonNull
    public final EditText bpl;
    @NonNull
    public final FrameLayout bpm;
    @NonNull
    public final AppCompatImageView bpn;
    @NonNull
    public final ConfirmButtonView bpo;

    protected gk(DataBindingComponent dataBindingComponent, View view, int i, AmountFrameViewSwitcher amountFrameViewSwitcher, TextView textView, ImageView imageView, AppCompatSpinner2 appCompatSpinner2, TextView textView2, EditText editText, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.bpg = amountFrameViewSwitcher;
        this.bph = textView;
        this.bpi = imageView;
        this.bpj = appCompatSpinner2;
        this.bpk = textView2;
        this.bpl = editText;
        this.bpm = frameLayout;
        this.bpn = appCompatImageView;
        this.bpo = confirmButtonView;
    }
}
