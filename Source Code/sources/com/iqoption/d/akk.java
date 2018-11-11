package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ToolbarLayoutBinding */
public abstract class akk extends ViewDataBinding {
    @NonNull
    public final ImageView bTH;
    @NonNull
    public final TextView bzw;

    protected akk(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bTH = imageView;
        this.bzw = textView;
    }
}
