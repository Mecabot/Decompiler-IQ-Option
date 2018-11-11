package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

/* compiled from: FragmentQuizOffAirTitleBinding */
public abstract class rl extends ViewDataBinding {
    @NonNull
    public final ImageView bBr;
    @NonNull
    public final View bBs;

    protected rl(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, View view2) {
        super(dataBindingComponent, view, i);
        this.bBr = imageView;
        this.bBs = view2;
    }
}
