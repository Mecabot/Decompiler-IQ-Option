package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: BottomSheetPortfolioTpslChooserBinding */
public abstract class bq extends ViewDataBinding {
    @NonNull
    public final TextView blE;
    @NonNull
    public final TextView blF;
    @NonNull
    public final TextView blG;
    @NonNull
    public final RecyclerView blH;
    @NonNull
    public final TextView blI;
    @NonNull
    public final RecyclerView blJ;
    @NonNull
    public final View blp;
    @NonNull
    public final LinearLayout blz;

    protected bq(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, View view2, LinearLayout linearLayout, TextView textView3, RecyclerView recyclerView, TextView textView4, RecyclerView recyclerView2) {
        super(dataBindingComponent, view, i);
        this.blE = textView;
        this.blF = textView2;
        this.blp = view2;
        this.blz = linearLayout;
        this.blG = textView3;
        this.blH = recyclerView;
        this.blI = textView4;
        this.blJ = recyclerView2;
    }
}
