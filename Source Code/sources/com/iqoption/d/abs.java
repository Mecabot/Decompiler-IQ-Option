package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.nps.NpsRatingBar;
import com.iqoption.fragment.dialog.nps.c;

/* compiled from: NpsScoreFragmentBinding */
public abstract class abs extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final ImageView bBI;
    @NonNull
    public final ImageView bMB;
    @NonNull
    public final FrameLayout bMC;
    @NonNull
    public final TextView bMD;
    @NonNull
    public final TextView bME;
    @NonNull
    public final NpsRatingBar bMF;
    @NonNull
    public final TextView bMG;
    @NonNull
    public final LinearLayout bMH;
    @NonNull
    public final TextView bMI;
    @NonNull
    public final TextView bMJ;
    @Bindable
    protected c bMK;
    @NonNull
    public final TextView bMy;
    @NonNull
    public final FrameLayout brn;
    @NonNull
    public final TextView bxT;

    public abstract void a(@Nullable c cVar);

    protected abs(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, NpsRatingBar npsRatingBar, TextView textView4, LinearLayout linearLayout, TextView textView5, TextView textView6, FrameLayout frameLayout2, TextView textView7) {
        super(dataBindingComponent, view, i);
        this.bBI = imageView;
        this.bMB = imageView2;
        this.axL = constraintLayout;
        this.bMC = frameLayout;
        this.bMD = textView;
        this.bME = textView2;
        this.bxT = textView3;
        this.bMF = npsRatingBar;
        this.bMG = textView4;
        this.bMH = linearLayout;
        this.bMI = textView5;
        this.bMy = textView6;
        this.brn = frameLayout2;
        this.bMJ = textView7;
    }
}
