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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: BottomSheetOtnEmissionHistoryBinding */
public abstract class bk extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final View blp;
    @NonNull
    public final ImageView blt;
    @NonNull
    public final RecyclerView blu;
    @NonNull
    public final FrameLayout blv;

    protected bk(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RecyclerView recyclerView, View view2, FrameLayout frameLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.blt = imageView;
        this.blu = recyclerView;
        this.blp = view2;
        this.blv = frameLayout;
        this.agA = textView;
    }

    @NonNull
    public static bk d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return d(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static bk d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (bk) DataBindingUtil.inflate(layoutInflater, R.layout.bottom_sheet_otn_emission_history, viewGroup, z, dataBindingComponent);
    }
}
