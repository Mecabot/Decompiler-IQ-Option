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

/* compiled from: BottomSheetChooserBinding */
public abstract class be extends ViewDataBinding {
    @NonNull
    public final RecyclerView axw;
    @NonNull
    public final View blp;

    protected be(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView, View view2) {
        super(dataBindingComponent, view, i);
        this.axw = recyclerView;
        this.blp = view2;
    }

    @NonNull
    public static be a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return a(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static be a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (be) DataBindingUtil.inflate(layoutInflater, R.layout.bottom_sheet_chooser, viewGroup, z, dataBindingComponent);
    }
}
