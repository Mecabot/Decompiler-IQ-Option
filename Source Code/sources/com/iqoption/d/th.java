package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentVerifyCardsBinding */
public abstract class th extends ViewDataBinding {
    @NonNull
    public final TextView bFn;
    @NonNull
    public final ContentLoadingProgressBar bFo;
    @NonNull
    public final RecyclerView bFp;

    protected th(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ContentLoadingProgressBar contentLoadingProgressBar, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bFn = textView;
        this.bFo = contentLoadingProgressBar;
        this.bFp = recyclerView;
    }

    @NonNull
    public static th C(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return C(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static th C(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (th) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_verify_cards, viewGroup, z, dataBindingComponent);
    }
}
