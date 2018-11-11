package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.welcomeonboarding.d.g;

/* compiled from: FragmentTwoStepAuthBinding */
public abstract class tf extends ViewDataBinding {
    @NonNull
    public final ImageView aOU;
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextInputEditText bFc;
    @NonNull
    public final TextInputLayout bFd;
    @NonNull
    public final TextView bFe;
    @NonNull
    public final TextView bFf;
    @NonNull
    public final TextView bFg;
    @NonNull
    public final TextView bFh;
    @Bindable
    protected g bFi;
    @NonNull
    public final LinearLayout bjl;
    @NonNull
    public final TextView bnd;
    @NonNull
    public final ContentLoadingProgressBar bnn;

    public abstract void a(@Nullable g gVar);

    protected tf(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextInputEditText textInputEditText, TextInputLayout textInputLayout, LinearLayout linearLayout, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(dataBindingComponent, view, i);
        this.aOU = imageView;
        this.bnd = textView;
        this.bFc = textInputEditText;
        this.bFd = textInputLayout;
        this.bjl = linearLayout;
        this.bnn = contentLoadingProgressBar;
        this.bFe = textView2;
        this.agA = textView3;
        this.bFf = textView4;
        this.bFg = textView5;
        this.bFh = textView6;
    }
}
