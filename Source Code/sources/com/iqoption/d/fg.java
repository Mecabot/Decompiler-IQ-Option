package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: CloseDelegateBinding */
public abstract class fg extends ViewDataBinding {
    @NonNull
    public final TextView bnA;
    @NonNull
    public final FrameLayout bne;
    @NonNull
    public final ImageView bnf;
    @NonNull
    public final ProgressBar bng;
    @NonNull
    public final FrameLayout bni;
    @NonNull
    public final TextView bnk;
    @NonNull
    public final TextView bnm;
    @NonNull
    public final ContentLoadingProgressBar bnn;
    @NonNull
    public final TextView bnt;
    @NonNull
    public final TextView bnu;
    @NonNull
    public final TextView bnv;
    @NonNull
    public final TextView bnw;
    @NonNull
    public final TextView bnx;
    @NonNull
    public final TextView bny;
    @NonNull
    public final LinearLayout bnz;

    protected fg(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, ImageView imageView, ProgressBar progressBar, TextView textView, FrameLayout frameLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, LinearLayout linearLayout, TextView textView8, TextView textView9, ContentLoadingProgressBar contentLoadingProgressBar) {
        super(dataBindingComponent, view, i);
        this.bne = frameLayout;
        this.bnf = imageView;
        this.bng = progressBar;
        this.bnt = textView;
        this.bni = frameLayout2;
        this.bnu = textView2;
        this.bnv = textView3;
        this.bnw = textView4;
        this.bnx = textView5;
        this.bnk = textView6;
        this.bny = textView7;
        this.bnz = linearLayout;
        this.bnA = textView8;
        this.bnm = textView9;
        this.bnn = contentLoadingProgressBar;
    }

    @NonNull
    public static fg g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static fg g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (fg) DataBindingUtil.inflate(layoutInflater, R.layout.close_delegate, viewGroup, z, dataBindingComponent);
    }
}
