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
import com.iqoption.x.R;

/* compiled from: ItemOvernightFeeScheduleBinding */
public abstract class wf extends ViewDataBinding {
    @NonNull
    public final TextView aiq;
    @NonNull
    public final TextView bJp;
    @NonNull
    public final TextView bJq;
    @NonNull
    public final TextView bJr;

    protected wf(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bJp = textView;
        this.bJq = textView2;
        this.bJr = textView3;
        this.aiq = textView4;
    }

    @NonNull
    public static wf L(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return L(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static wf L(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (wf) DataBindingUtil.inflate(layoutInflater, R.layout.item_overnight_fee_schedule, viewGroup, z, dataBindingComponent);
    }
}
