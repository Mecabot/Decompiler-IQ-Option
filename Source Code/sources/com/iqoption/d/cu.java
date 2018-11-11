package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ChatFilePickerItemBinding */
public abstract class cu extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView biD;
    @NonNull
    public final ImageView bmu;

    protected cu(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bmu = imageView;
        this.biD = textView;
        this.agA = textView2;
    }
}
