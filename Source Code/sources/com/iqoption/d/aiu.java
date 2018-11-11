package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: SellDelegateBinding */
public abstract class aiu extends ViewDataBinding {
    @NonNull
    public final TextView agS;
    @NonNull
    public final TextView bTh;
    @NonNull
    public final FrameLayout bTi;
    @NonNull
    public final TextView bTj;
    @NonNull
    public final TextView bTk;
    @NonNull
    public final TextView bnA;
    @NonNull
    public final TextView bnm;
    @NonNull
    public final ContentLoadingProgressBar bnn;
    @NonNull
    public final TextView bny;
    @NonNull
    public final TextView bvn;

    protected aiu(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView6, FrameLayout frameLayout, TextView textView7, TextView textView8) {
        super(dataBindingComponent, view, i);
        this.bny = textView;
        this.bnA = textView2;
        this.bnm = textView3;
        this.agS = textView4;
        this.bvn = textView5;
        this.bnn = contentLoadingProgressBar;
        this.bTh = textView6;
        this.bTi = frameLayout;
        this.bTj = textView7;
        this.bTk = textView8;
    }

    @NonNull
    public static aiu aA(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return aA(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aiu aA(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (aiu) DataBindingUtil.inflate(layoutInflater, R.layout.sell_delegate, viewGroup, z, dataBindingComponent);
    }
}
