package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: FragmentQuizLeaderboardFilterBinding */
public abstract class rb extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final RecyclerView axw;

    protected rb(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.axw = recyclerView;
        this.agA = textView;
    }
}
