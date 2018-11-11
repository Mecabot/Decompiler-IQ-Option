package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: DialogWhatsNewBinding */
public abstract class jz extends ViewDataBinding {
    @NonNull
    public final ImageView aEt;
    @NonNull
    public final TextView agA;
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final ImageView blt;
    @NonNull
    public final LinearLayout bmC;
    @NonNull
    public final TextView buE;
    @NonNull
    public final ImageView buF;
    @NonNull
    public final TextView buG;
    @NonNull
    public final TextView buH;
    @NonNull
    public final TextView buI;
    @NonNull
    public final FrameLayout buJ;
    @NonNull
    public final View buK;

    protected jz(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, ImageView imageView3, TextView textView4, TextView textView5, LinearLayout linearLayout, FrameLayout frameLayout, View view2) {
        super(dataBindingComponent, view, i);
        this.blt = imageView;
        this.buE = textView;
        this.buF = imageView2;
        this.buG = textView2;
        this.axL = constraintLayout;
        this.buH = textView3;
        this.aEt = imageView3;
        this.buI = textView4;
        this.agA = textView5;
        this.bmC = linearLayout;
        this.buJ = frameLayout;
        this.buK = view2;
    }
}
