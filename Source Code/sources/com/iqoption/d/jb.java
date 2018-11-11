package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.fragment.bw;

/* compiled from: DialogOvernightFeeInfoBinding */
public abstract class jb extends ViewDataBinding {
    @NonNull
    public final LinearLayout bjl;
    @NonNull
    public final FrameLayout brJ;
    @NonNull
    public final RecyclerView btf;
    @NonNull
    public final TextView btg;
    @Bindable
    protected bw bth;

    public abstract void a(@Nullable bw bwVar);

    protected jb(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.bjl = linearLayout;
        this.btf = recyclerView;
        this.btg = textView;
        this.brJ = frameLayout;
    }
}
