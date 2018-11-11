package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: WithdrawHistoryPayoutItemBinding */
public abstract class amn extends ViewDataBinding {
    @NonNull
    public final View bUQ;
    @NonNull
    public final ImageView bUR;
    @NonNull
    public final ContentLoadingProgressBar bUS;
    @NonNull
    public final Guideline bUT;
    @NonNull
    public final TextView bUU;
    @NonNull
    public final ImageView bUV;
    @NonNull
    public final TextView bUW;
    @NonNull
    public final TextView bUX;

    protected amn(DataBindingComponent dataBindingComponent, View view, int i, View view2, ImageView imageView, ContentLoadingProgressBar contentLoadingProgressBar, Guideline guideline, TextView textView, ImageView imageView2, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bUQ = view2;
        this.bUR = imageView;
        this.bUS = contentLoadingProgressBar;
        this.bUT = guideline;
        this.bUU = textView;
        this.bUV = imageView2;
        this.bUW = textView2;
        this.bUX = textView3;
    }
}
