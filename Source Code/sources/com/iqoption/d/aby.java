package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.view.timer.TimerView;

/* compiled from: OpenBinaryOptionGroupItemBinding */
public abstract class aby extends ViewDataBinding {
    @NonNull
    public final TextView axH;
    @NonNull
    public final View bBw;
    @NonNull
    public final FrameLayout bMU;
    @NonNull
    public final LinearLayout bMV;
    @NonNull
    public final RobotoTextView bMW;
    @NonNull
    public final FormattedTextView bMX;
    @NonNull
    public final ContentLoadingProgressBar bMY;
    @NonNull
    public final ImageView bMZ;
    @NonNull
    public final FrameLayout bNa;
    @NonNull
    public final LinearLayout bNb;
    @NonNull
    public final LinearLayout bNc;
    @NonNull
    public final LinearLayout bNd;
    @NonNull
    public final TextView bNe;
    @NonNull
    public final RobotoTextView bNf;
    @NonNull
    public final TimerView blb;
    @NonNull
    public final TextView bnD;
    @NonNull
    public final TextView bnE;
    @NonNull
    public final agg bnH;
    @NonNull
    public final FormattedTextView bnI;
    @NonNull
    public final RobotoTextView bnJ;

    protected aby(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout, LinearLayout linearLayout, RobotoTextView robotoTextView, agg agg, FormattedTextView formattedTextView, View view2, ContentLoadingProgressBar contentLoadingProgressBar, ImageView imageView, FrameLayout frameLayout2, LinearLayout linearLayout2, LinearLayout linearLayout3, FormattedTextView formattedTextView2, LinearLayout linearLayout4, TextView textView4, RobotoTextView robotoTextView2, TimerView timerView, RobotoTextView robotoTextView3) {
        super(dataBindingComponent, view, i);
        this.axH = textView;
        this.bnD = textView2;
        this.bnE = textView3;
        this.bMU = frameLayout;
        this.bMV = linearLayout;
        this.bMW = robotoTextView;
        this.bnH = agg;
        setContainedBinding(this.bnH);
        this.bMX = formattedTextView;
        this.bBw = view2;
        this.bMY = contentLoadingProgressBar;
        this.bMZ = imageView;
        this.bNa = frameLayout2;
        this.bNb = linearLayout2;
        this.bNc = linearLayout3;
        this.bnI = formattedTextView2;
        this.bNd = linearLayout4;
        this.bNe = textView4;
        this.bNf = robotoTextView2;
        this.blb = timerView;
        this.bnJ = robotoTextView3;
    }
}
