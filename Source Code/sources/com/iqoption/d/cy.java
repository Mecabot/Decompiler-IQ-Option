package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: ChatFragmentFilePickerBinding */
public abstract class cy extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView awN;
    @NonNull
    public final RecyclerView bmB;
    @NonNull
    public final LinearLayout bmC;

    protected cy(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RecyclerView recyclerView, TextView textView, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.awN = imageView;
        this.bmB = recyclerView;
        this.agA = textView;
        this.bmC = linearLayout;
    }
}
