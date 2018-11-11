package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: OtnLeaderBoardSelectCountryItemBinding */
public abstract class ada extends ViewDataBinding {
    @NonNull
    public final ImageView bNS;
    @NonNull
    public final TextView bNT;

    protected ada(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bNS = imageView;
        this.bNT = textView;
    }
}
