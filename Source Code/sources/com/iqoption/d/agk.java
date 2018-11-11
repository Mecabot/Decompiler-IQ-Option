package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;

/* compiled from: PriceMovementsFilterFragmentBinding */
public abstract class agk extends ViewDataBinding {
    @NonNull
    public final ListView bPV;

    protected agk(DataBindingComponent dataBindingComponent, View view, int i, ListView listView) {
        super(dataBindingComponent, view, i);
        this.bPV = listView;
    }
}
