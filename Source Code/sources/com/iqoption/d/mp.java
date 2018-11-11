package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: FragmentKycDocumentsUploadBinding */
public abstract class mp extends ViewDataBinding {
    @NonNull
    public final TextView bxF;
    @NonNull
    public final ImageView bxV;
    @NonNull
    public final LinearLayout bxW;
    @NonNull
    public final ContentLoadingProgressBar bxX;
    @NonNull
    public final TextView bxY;
    @NonNull
    public final ConfirmButtonView bxZ;
    @NonNull
    public final wr bxz;
    @NonNull
    public final TextView bya;
    @NonNull
    public final LinearLayout byb;
    @NonNull
    public final ContentLoadingProgressBar byc;
    @NonNull
    public final TextView byd;
    @NonNull
    public final TextView bye;
    @NonNull
    public final TextView byf;

    protected mp(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView, TextView textView2, ConfirmButtonView confirmButtonView, TextView textView3, wr wrVar, LinearLayout linearLayout2, ContentLoadingProgressBar contentLoadingProgressBar2, TextView textView4, TextView textView5, TextView textView6) {
        super(dataBindingComponent, view, i);
        this.bxV = imageView;
        this.bxW = linearLayout;
        this.bxX = contentLoadingProgressBar;
        this.bxY = textView;
        this.bxF = textView2;
        this.bxZ = confirmButtonView;
        this.bya = textView3;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.byb = linearLayout2;
        this.byc = contentLoadingProgressBar2;
        this.byd = textView4;
        this.bye = textView5;
        this.byf = textView6;
    }
}
