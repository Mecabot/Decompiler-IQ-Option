package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: OpenDigitalOptionItemBinding */
public abstract class ack extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bNH;
    @NonNull
    public final RobotoTextView bNI;
    @NonNull
    public final LinearLayout bNJ;
    @NonNull
    public final RobotoTextView bNK;
    @NonNull
    public final RobotoTextView bNL;
    @NonNull
    public final LinearLayout bNc;
    @NonNull
    public final TextView bNe;
    @NonNull
    public final RobotoTextView bNf;
    @NonNull
    public final ContentLoadingProgressBar bNj;
    @NonNull
    public final RobotoTextView blS;
    @NonNull
    public final RobotoTextView bnJ;

    protected ack(DataBindingComponent dataBindingComponent, View view, int i, ContentLoadingProgressBar contentLoadingProgressBar, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, LinearLayout linearLayout, RobotoTextView robotoTextView3, LinearLayout linearLayout2, TextView textView, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5, RobotoTextView robotoTextView6, RobotoTextView robotoTextView7) {
        super(dataBindingComponent, view, i);
        this.bNj = contentLoadingProgressBar;
        this.bNH = robotoTextView;
        this.blS = robotoTextView2;
        this.bNc = linearLayout;
        this.bNI = robotoTextView3;
        this.bNJ = linearLayout2;
        this.bNe = textView;
        this.bNf = robotoTextView4;
        this.bNK = robotoTextView5;
        this.bNL = robotoTextView6;
        this.bnJ = robotoTextView7;
    }
}
