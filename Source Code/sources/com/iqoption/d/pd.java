package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentOperationHistoryOptionsBinding */
public abstract class pd extends ViewDataBinding {
    @NonNull
    public final View biw;
    @NonNull
    public final LinearLayout biz;
    @NonNull
    public final TextView bnk;
    @NonNull
    public final RecyclerView bzv;
    @NonNull
    public final TextView bzw;

    protected pd(DataBindingComponent dataBindingComponent, View view, int i, View view2, TextView textView, RecyclerView recyclerView, LinearLayout linearLayout, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.biw = view2;
        this.bnk = textView;
        this.bzv = recyclerView;
        this.biz = linearLayout;
        this.bzw = textView2;
    }
}
