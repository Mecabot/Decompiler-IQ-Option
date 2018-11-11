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
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: ClosePositionDelegateBinding */
public abstract class fi extends ViewDataBinding {
    @NonNull
    public final TextView bnA;
    @NonNull
    public final TextView bnB;
    @NonNull
    public final FrameLayout bni;
    @NonNull
    public final TextView bnm;
    @NonNull
    public final ContentLoadingProgressBar bnn;
    @NonNull
    public final ImageView bno;
    @NonNull
    public final TextView bns;
    @NonNull
    public final TextView bnt;
    @NonNull
    public final TextView bnu;
    @NonNull
    public final TextView bnv;
    @NonNull
    public final TextView bnw;
    @NonNull
    public final TextView bny;
    @NonNull
    public final LinearLayout bnz;

    protected fi(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout, TextView textView6, TextView textView7, ContentLoadingProgressBar contentLoadingProgressBar, ImageView imageView, TextView textView8, TextView textView9) {
        super(dataBindingComponent, view, i);
        this.bnt = textView;
        this.bni = frameLayout;
        this.bnu = textView2;
        this.bnv = textView3;
        this.bnw = textView4;
        this.bny = textView5;
        this.bnz = linearLayout;
        this.bnA = textView6;
        this.bnm = textView7;
        this.bnn = contentLoadingProgressBar;
        this.bno = imageView;
        this.bnB = textView8;
        this.bns = textView9;
    }

    @NonNull
    public static fi h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static fi h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (fi) DataBindingUtil.inflate(layoutInflater, R.layout.close_position_delegate, viewGroup, z, dataBindingComponent);
    }
}
