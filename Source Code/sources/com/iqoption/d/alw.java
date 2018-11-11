package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: VipEducationSessionItemBinding */
public abstract class alw extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView bUv;
    @NonNull
    public final TextView bmE;

    protected alw(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bUv = imageView;
        this.bmE = textView;
        this.agA = textView2;
    }
}
