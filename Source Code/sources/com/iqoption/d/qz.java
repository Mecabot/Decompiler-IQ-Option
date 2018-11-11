package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentQuizLeaderboardDelegateBinding */
public abstract class qz extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final RecyclerView axw;
    @NonNull
    public final TextView bAZ;
    @NonNull
    public final TextView bBa;
    @NonNull
    public final rf bBb;

    protected qz(DataBindingComponent dataBindingComponent, View view, int i, ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, TextView textView2, TextView textView3, rf rfVar) {
        super(dataBindingComponent, view, i);
        this.axL = constraintLayout;
        this.bAZ = textView;
        this.axw = recyclerView;
        this.agA = textView2;
        this.bBa = textView3;
        this.bBb = rfVar;
        setContainedBinding(this.bBb);
    }
}
