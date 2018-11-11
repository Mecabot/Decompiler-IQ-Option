package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* compiled from: IndicatorConstructorBottomSheetInputSelectBinding */
public abstract class g extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final RecyclerView axw;

    protected g(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.axw = recyclerView;
        this.agA = textView;
    }
}
