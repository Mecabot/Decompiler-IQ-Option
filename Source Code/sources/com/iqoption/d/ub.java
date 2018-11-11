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
import android.widget.ToggleButton;
import com.iqoption.welcomeonboarding.b.i;

/* compiled from: FragmentWelcomeLoginBinding */
public abstract class ub extends ViewDataBinding {
    @NonNull
    public final ImageView aOU;
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextInputEditText bEP;
    @NonNull
    public final ToggleButton bER;
    @NonNull
    public final TextView bGh;
    @NonNull
    public final TextInputLayout bGi;
    @NonNull
    public final xf bGj;
    @Bindable
    protected i bGk;
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

    public abstract void a(@Nullable i iVar);

    protected ub(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, FrameLayout frameLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView2, TextInputEditText textInputEditText2, TextInputLayout textInputLayout2, ToggleButton toggleButton, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView3, xf xfVar) {
        super(dataBindingComponent, view, i);
        this.aOU = imageView;
        this.bnd = textView;
        this.blV = frameLayout;
        this.bxq = textInputEditText;
        this.bxr = textInputLayout;
        this.bGh = textView2;
        this.bEP = textInputEditText2;
        this.bGi = textInputLayout2;
        this.bER = toggleButton;
        this.bnn = contentLoadingProgressBar;
        this.agA = textView3;
        this.bGj = xfVar;
        setContainedBinding(this.bGj);
    }
}
