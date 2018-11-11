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

/* compiled from: BottomSheetPortfolioFilterChooserBinding */
public abstract class bo extends ViewDataBinding {
    @NonNull
    public final RecyclerView blD;
    @NonNull
    public final View blp;

    protected bo(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView, View view2) {
        super(dataBindingComponent, view, i);
        this.blD = recyclerView;
        this.blp = view2;
    }

    @NonNull
    public static bo f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static bo f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (bo) DataBindingUtil.inflate(layoutInflater, R.layout.bottom_sheet_portfolio_filter_chooser, viewGroup, z, dataBindingComponent);
    }
}
