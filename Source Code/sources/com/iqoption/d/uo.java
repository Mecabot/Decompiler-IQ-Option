package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.x.R;

/* compiled from: FragmentWithdrawHistoryBinding */
public abstract class uo extends ViewDataBinding {
    @NonNull
    public final RecyclerView bHm;

    protected uo(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bHm = recyclerView;
    }

    @NonNull
    public static uo H(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return H(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static uo H(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (uo) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_withdraw_history, viewGroup, z, dataBindingComponent);
    }
}
