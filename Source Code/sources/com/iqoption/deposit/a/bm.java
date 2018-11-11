package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.IQTextInputLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/* compiled from: LayoutDepositContentBinding */
public abstract class bm extends ViewDataBinding {
    @NonNull
    public final View bZY;
    @NonNull
    public final be bZZ;
    @NonNull
    public final FrameLayout bZe;
    @NonNull
    public final RecyclerView bZh;
    @NonNull
    public final TextView bZi;
    @NonNull
    public final TextInputEditText caa;
    @NonNull
    public final IQTextInputLayout cab;
    @NonNull
    public final bi cac;
    @NonNull
    public final ScrollView cad;
    @NonNull
    public final bx cae;

    protected bm(DataBindingComponent dataBindingComponent, View view, int i, View view2, be beVar, TextInputEditText textInputEditText, IQTextInputLayout iQTextInputLayout, bi biVar, FrameLayout frameLayout, RecyclerView recyclerView, ScrollView scrollView, TextView textView, bx bxVar) {
        super(dataBindingComponent, view, i);
        this.bZY = view2;
        this.bZZ = beVar;
        setContainedBinding(this.bZZ);
        this.caa = textInputEditText;
        this.cab = iQTextInputLayout;
        this.cac = biVar;
        setContainedBinding(this.cac);
        this.bZe = frameLayout;
        this.bZh = recyclerView;
        this.cad = scrollView;
        this.bZi = textView;
        this.cae = bxVar;
        setContainedBinding(this.cae);
    }
}
