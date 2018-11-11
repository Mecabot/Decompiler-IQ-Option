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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentWithdrawFieldsBinding */
public abstract class um extends ViewDataBinding {
    @NonNull
    public final View bHc;
    @NonNull
    public final View bHd;
    @NonNull
    public final TextView bHe;
    @NonNull
    public final TextView bHf;
    @NonNull
    public final LinearLayout bHg;
    @NonNull
    public final amr bHh;
    @NonNull
    public final LinearLayout bHi;
    @NonNull
    public final FrameLayout bHj;
    @NonNull
    public final TextView bHk;
    @NonNull
    public final TextView bHl;

    protected um(DataBindingComponent dataBindingComponent, View view, int i, View view2, View view3, TextView textView, TextView textView2, LinearLayout linearLayout, amr amr, LinearLayout linearLayout2, FrameLayout frameLayout, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bHc = view2;
        this.bHd = view3;
        this.bHe = textView;
        this.bHf = textView2;
        this.bHg = linearLayout;
        this.bHh = amr;
        setContainedBinding(this.bHh);
        this.bHi = linearLayout2;
        this.bHj = frameLayout;
        this.bHk = textView3;
        this.bHl = textView4;
    }

    @NonNull
    public static um G(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return G(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static um G(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (um) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_withdraw_fields, viewGroup, z, dataBindingComponent);
    }
}
