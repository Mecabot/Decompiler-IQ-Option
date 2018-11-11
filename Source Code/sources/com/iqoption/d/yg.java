package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.TextView;

/* compiled from: LeftMenuItemWithProgressBinding */
public abstract class yg extends ViewDataBinding {
    @NonNull
    public final ContentLoadingProgressBar bKG;
    @NonNull
    public final TextView bKs;

    protected yg(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ContentLoadingProgressBar contentLoadingProgressBar) {
        super(dataBindingComponent, view, i);
        this.bKs = textView;
        this.bKG = contentLoadingProgressBar;
    }
}
