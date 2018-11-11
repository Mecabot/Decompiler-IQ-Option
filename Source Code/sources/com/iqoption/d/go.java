package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: DepositPageBinding */
public abstract class go extends ViewDataBinding {
    @NonNull
    public final ImageView boF;
    @NonNull
    public final TextView boG;
    @NonNull
    public final View boH;
    @NonNull
    public final View boI;
    @NonNull
    public final TextView bps;
    @NonNull
    public final TextView bpt;
    @NonNull
    public final NestedScrollView bpu;

    protected go(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3, View view2, View view3, NestedScrollView nestedScrollView) {
        super(dataBindingComponent, view, i);
        this.boF = imageView;
        this.bps = textView;
        this.bpt = textView2;
        this.boG = textView3;
        this.boH = view2;
        this.boI = view3;
        this.bpu = nestedScrollView;
    }

    @NonNull
    public static go k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static go k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (go) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_page, viewGroup, z, dataBindingComponent);
    }
}
