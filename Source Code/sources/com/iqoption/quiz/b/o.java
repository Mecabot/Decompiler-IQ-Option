package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.quiz.widget.CountDownProgressBar;

/* compiled from: QuestionLayoutBinding */
public abstract class o extends ViewDataBinding {
    @NonNull
    public final TextView dkA;
    @NonNull
    public final CountDownProgressBar dkR;
    @NonNull
    public final TextView dkl;
    @NonNull
    public final TextView dkm;
    @NonNull
    public final TextView dkn;
    @NonNull
    public final ImageView dkw;
    @NonNull
    public final TextView dky;
    @NonNull
    public final TextView dkz;

    protected o(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, TextView textView5, CountDownProgressBar countDownProgressBar, TextView textView6) {
        super(dataBindingComponent, view, i);
        this.dkl = textView;
        this.dkm = textView2;
        this.dkn = textView3;
        this.dkw = imageView;
        this.dky = textView4;
        this.dkz = textView5;
        this.dkR = countDownProgressBar;
        this.dkA = textView6;
    }
}
