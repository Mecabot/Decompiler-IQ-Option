package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: PopupWindowOtnLeaderBoardSelectCountryBinding */
public abstract class adm extends ViewDataBinding {
    @NonNull
    public final RecyclerView bON;

    protected adm(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bON = recyclerView;
    }
}
