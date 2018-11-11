package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: WinnersLayoutBinding */
public abstract class aa extends ViewDataBinding {
    @NonNull
    public final TextView dlf;
    @NonNull
    public final RecyclerView dlg;

    protected aa(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.dlf = textView;
        this.dlg = recyclerView;
    }
}
