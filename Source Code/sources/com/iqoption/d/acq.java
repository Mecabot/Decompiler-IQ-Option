package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: OperationSearchResultItemBinding */
public abstract class acq extends ViewDataBinding {
    @NonNull
    public final TextView bNO;
    @NonNull
    public final TextView bNP;
    @NonNull
    public final TextView bNQ;
    @NonNull
    public final ImageView bmu;
    @NonNull
    public final TextView btG;

    protected acq(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.btG = textView;
        this.bmu = imageView;
        this.bNO = textView2;
        this.bNP = textView3;
        this.bNQ = textView4;
    }
}
