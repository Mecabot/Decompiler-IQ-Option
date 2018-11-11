package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.x.R;

/* compiled from: PopupWindowCurrencySelectionBinding */
public abstract class adk extends ViewDataBinding {
    @NonNull
    public final CardView bOL;
    @NonNull
    public final RecyclerView bOM;

    protected adk(DataBindingComponent dataBindingComponent, View view, int i, CardView cardView, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bOL = cardView;
        this.bOM = recyclerView;
    }

    @NonNull
    public static adk aj(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return aj(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static adk aj(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (adk) DataBindingUtil.inflate(layoutInflater, R.layout.popup_window_currency_selection, viewGroup, z, dataBindingComponent);
    }
}
