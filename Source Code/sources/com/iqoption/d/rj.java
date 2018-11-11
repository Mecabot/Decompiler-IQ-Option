package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: FragmentQuizOffAirDelegateBinding */
public abstract class rj extends ViewDataBinding {
    @NonNull
    public final TextView bBg;
    @NonNull
    public final ImageView bBh;
    @NonNull
    public final TextView bBi;
    @NonNull
    public final ImageView bBj;
    @NonNull
    public final TextView bBk;
    @NonNull
    public final TextView bBl;
    @NonNull
    public final TextView bBm;
    @NonNull
    public final TextView bBn;
    @NonNull
    public final TextView bBo;
    @NonNull
    public final TextView bBp;
    @NonNull
    public final rl bBq;

    protected rj(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, rl rlVar) {
        super(dataBindingComponent, view, i);
        this.bBg = textView;
        this.bBh = imageView;
        this.bBi = textView2;
        this.bBj = imageView2;
        this.bBk = textView3;
        this.bBl = textView4;
        this.bBm = textView5;
        this.bBn = textView6;
        this.bBo = textView7;
        this.bBp = textView8;
        this.bBq = rlVar;
        setContainedBinding(this.bBq);
    }
}
