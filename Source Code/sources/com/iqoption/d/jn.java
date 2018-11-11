package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeConstraintLayout;

/* compiled from: DialogQuizUserProfileBinding */
public abstract class jn extends ViewDataBinding {
    @NonNull
    public final TextView aiF;
    @NonNull
    public final TextView aig;
    @NonNull
    public final FrameLayout awS;
    @NonNull
    public final ImageView bmj;
    @NonNull
    public final TextView bmk;
    @NonNull
    public final TextView bml;
    @NonNull
    public final FrameLayout bmm;
    @NonNull
    public final TextView bmn;
    @NonNull
    public final FrameLayout bmo;
    @NonNull
    public final TextView bmp;
    @NonNull
    public final MaxSizeConstraintLayout btF;

    protected jn(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2, FrameLayout frameLayout, TextView textView3, TextView textView4, MaxSizeConstraintLayout maxSizeConstraintLayout, TextView textView5, FrameLayout frameLayout2, FrameLayout frameLayout3, TextView textView6) {
        super(dataBindingComponent, view, i);
        this.bmj = imageView;
        this.bmk = textView;
        this.bml = textView2;
        this.bmm = frameLayout;
        this.aiF = textView3;
        this.bmn = textView4;
        this.btF = maxSizeConstraintLayout;
        this.aig = textView5;
        this.bmo = frameLayout2;
        this.awS = frameLayout3;
        this.bmp = textView6;
    }
}
