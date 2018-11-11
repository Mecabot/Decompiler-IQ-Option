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

/* compiled from: OpenCfdItemBinding */
public abstract class ace extends ViewDataBinding {
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
    public final RobotoTextView bNC;
    @NonNull
    public final TextView bND;
    @NonNull
    public final RobotoTextView bNE;
    @NonNull
    public final RobotoTextView bNF;
    @NonNull
    public final LinearLayout bNc;
    @NonNull
    public final ContentLoadingProgressBar bNj;
    @NonNull
    public final RobotoTextView blC;
    @NonNull
    public final RobotoTextView blS;

    protected ace(DataBindingComponent dataBindingComponent, View view, int i, ContentLoadingProgressBar contentLoadingProgressBar, RobotoTextView robotoTextView, ImageView imageView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, LinearLayout linearLayout, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5, TextView textView, RobotoTextView robotoTextView6, LinearLayout linearLayout2, RobotoTextView robotoTextView7, LinearLayout linearLayout3, RobotoTextView robotoTextView8) {
        super(dataBindingComponent, view, i);
        this.bNj = contentLoadingProgressBar;
        this.bLw = robotoTextView;
        this.bNB = imageView;
        this.blS = robotoTextView2;
        this.bNC = robotoTextView3;
        this.bNc = linearLayout;
        this.bDV = robotoTextView4;
        this.bEa = robotoTextView5;
        this.bND = textView;
        this.bNE = robotoTextView6;
        this.bLG = linearLayout2;
        this.bNF = robotoTextView7;
        this.bLI = linearLayout3;
        this.blC = robotoTextView8;
    }
}
