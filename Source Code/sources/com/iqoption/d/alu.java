package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: VipEducationItemViewBinding */
public abstract class alu extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView bUv;
    @NonNull
    public final ImageView bUw;
    @NonNull
    public final TextView bmE;

    protected alu(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bUv = imageView;
        this.bUw = imageView2;
        this.bmE = textView;
        this.agA = textView2;
    }
}
