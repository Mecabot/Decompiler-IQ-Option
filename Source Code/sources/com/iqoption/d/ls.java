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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.welcomeonboarding.a.f;

/* compiled from: FragmentForgotPasswordBinding */
public abstract class ls extends ViewDataBinding {
    @NonNull
    public final ImageView aOU;
    @NonNull
    public final TextView agA;
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final TextView bnd;
    @NonNull
    public final ContentLoadingProgressBar bnn;
    @NonNull
    public final TextInputEditText bxq;
    @NonNull
    public final TextInputLayout bxr;
    @Bindable
    protected f bxs;

    public abstract void a(@Nullable f fVar);

    protected ls(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, FrameLayout frameLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.aOU = imageView;
        this.bnd = textView;
        this.blV = frameLayout;
        this.bxq = textInputEditText;
        this.bxr = textInputLayout;
        this.bnn = contentLoadingProgressBar;
        this.agA = textView2;
    }
}
