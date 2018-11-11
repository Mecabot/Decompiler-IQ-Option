package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FeedOptionsBinding */
public abstract class kt extends ViewDataBinding {
    @NonNull
    public final TextView bvL;
    @NonNull
    public final TextView bvM;
    @NonNull
    public final LinearLayout bvN;
    @NonNull
    public final TextView bvO;

    protected kt(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bvL = textView;
        this.bvM = textView2;
        this.bvN = linearLayout;
        this.bvO = textView3;
    }
}
