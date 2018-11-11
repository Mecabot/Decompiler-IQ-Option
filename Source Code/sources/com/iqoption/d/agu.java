package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: PriceMovementsHighFrequencyLayoutBinding */
public abstract class agu extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bQf;
    @NonNull
    public final RecyclerView bQg;

    protected agu(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView, RecyclerView recyclerView) {
        super(dataBindingComponent, view, i);
        this.bQf = formattedTextView;
        this.bQg = recyclerView;
    }
}
