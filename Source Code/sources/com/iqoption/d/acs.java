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

/* compiled from: OtnHistoryItemBinding */
public abstract class acs extends ViewDataBinding {
    @NonNull
    public final TextView aiq;
    @NonNull
    public final TextView bnj;

    protected acs(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bnj = textView;
        this.aiq = textView2;
    }

    @NonNull
    public static acs ag(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ag(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static acs ag(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (acs) DataBindingUtil.inflate(layoutInflater, R.layout.otn_history_item, viewGroup, z, dataBindingComponent);
    }
}
