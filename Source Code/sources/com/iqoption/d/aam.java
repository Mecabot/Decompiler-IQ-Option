package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: MicroPortfolioPageClosedPositionsBinding */
public abstract class aam extends ViewDataBinding {
    @NonNull
    public final ProgressBar Hw;
    @NonNull
    public final RecyclerView axw;
    @NonNull
    public final TextView bMf;
    @NonNull
    public final LinearLayout bMg;

    protected aam(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, RecyclerView recyclerView, ProgressBar progressBar) {
        super(dataBindingComponent, view, i);
        this.bMf = textView;
        this.bMg = linearLayout;
        this.axw = recyclerView;
        this.Hw = progressBar;
    }

    @Nullable
    public static aam a(@NonNull LayoutInflater layoutInflater) {
        return a(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aam a(@NonNull LayoutInflater layoutInflater, @Nullable DataBindingComponent dataBindingComponent) {
        return (aam) DataBindingUtil.inflate(layoutInflater, R.layout.micro_portfolio_page_closed_positions, null, false, dataBindingComponent);
    }
}
