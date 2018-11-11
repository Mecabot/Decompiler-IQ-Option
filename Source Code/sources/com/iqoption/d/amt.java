package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.x.R;

/* compiled from: WithdrawLimitReasonDialogBinding */
public abstract class amt extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView aip;
    @NonNull
    public final FrameLayout awS;
    @NonNull
    public final TextView bma;
    @NonNull
    public final MaxSizeCardViewLayout bmb;

    protected amt(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, MaxSizeCardViewLayout maxSizeCardViewLayout, FrameLayout frameLayout, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bma = textView;
        this.bmb = maxSizeCardViewLayout;
        this.awS = frameLayout;
        this.aip = textView2;
        this.agA = textView3;
    }

    @NonNull
    public static amt aD(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return aD(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static amt aD(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (amt) DataBindingUtil.inflate(layoutInflater, R.layout.withdraw_limit_reason_dialog, viewGroup, z, dataBindingComponent);
    }
}
