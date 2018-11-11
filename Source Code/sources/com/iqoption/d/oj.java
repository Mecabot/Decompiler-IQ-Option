package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: FragmentLocaleAssetSearchCountryBinding */
public abstract class oj extends ViewDataBinding {
    @NonNull
    public final RecyclerView axw;
    @NonNull
    public final View blp;
    @NonNull
    public final ProgressBar bly;
    @NonNull
    public final LinearLayout blz;
    @NonNull
    public final ImageView byW;
    @NonNull
    public final TextView byX;
    @NonNull
    public final LinearLayout byY;

    protected oj(DataBindingComponent dataBindingComponent, View view, int i, RecyclerView recyclerView, View view2, ProgressBar progressBar, ImageView imageView, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(dataBindingComponent, view, i);
        this.axw = recyclerView;
        this.blp = view2;
        this.bly = progressBar;
        this.byW = imageView;
        this.byX = textView;
        this.byY = linearLayout;
        this.blz = linearLayout2;
    }
}
