package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: OpenCryptoItemBinding */
public abstract class acg extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bDV;
    @NonNull
    public final RobotoTextView bEa;
    @NonNull
    public final LinearLayout bLG;
    @NonNull
    public final LinearLayout bLI;
    @NonNull
    public final RobotoTextView bLw;
    @NonNull
    public final ImageView bNB;
    @NonNull
    public final TextView bND;
    @NonNull
    public final RobotoTextView bNE;
    @NonNull
    public final RobotoTextView bNF;
    @NonNull
    public final RobotoTextView bNG;
    @NonNull
    public final LinearLayout bNc;
    @NonNull
    public final ContentLoadingProgressBar bNj;
    @NonNull
    public final RobotoTextView blS;

    protected acg(DataBindingComponent dataBindingComponent, View view, int i, ContentLoadingProgressBar contentLoadingProgressBar, RobotoTextView robotoTextView, ImageView imageView, RobotoTextView robotoTextView2, LinearLayout linearLayout, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5, TextView textView, RobotoTextView robotoTextView6, LinearLayout linearLayout2, RobotoTextView robotoTextView7, LinearLayout linearLayout3) {
        super(dataBindingComponent, view, i);
        this.bNj = contentLoadingProgressBar;
        this.bLw = robotoTextView;
        this.bNB = imageView;
        this.blS = robotoTextView2;
        this.bNc = linearLayout;
        this.bDV = robotoTextView3;
        this.bEa = robotoTextView4;
        this.bNG = robotoTextView5;
        this.bND = textView;
        this.bNE = robotoTextView6;
        this.bLG = linearLayout2;
        this.bNF = robotoTextView7;
        this.bLI = linearLayout3;
    }
}
