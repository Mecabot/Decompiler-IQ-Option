package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentOperationSearchResultBinding */
public abstract class pg extends ViewDataBinding {
    @NonNull
    public final View biw;
    @NonNull
    public final LinearLayout biz;
    @NonNull
    public final ContentLoadingProgressBar bnO;
    @NonNull
    public final TextView bzw;
    @NonNull
    public final LinearLayout bzx;
    @NonNull
    public final RecyclerView bzy;

    protected pg(DataBindingComponent dataBindingComponent, View view, int i, View view2, ContentLoadingProgressBar contentLoadingProgressBar, LinearLayout linearLayout, RecyclerView recyclerView, LinearLayout linearLayout2, TextView textView) {
        super(dataBindingComponent, view, i);
        this.biw = view2;
        this.bnO = contentLoadingProgressBar;
        this.bzx = linearLayout;
        this.bzy = recyclerView;
        this.biz = linearLayout2;
        this.bzw = textView;
    }
}
