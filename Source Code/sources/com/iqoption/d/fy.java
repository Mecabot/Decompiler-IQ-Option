package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

/* compiled from: DepositCardProcessingPageBinding */
public abstract class fy extends ViewDataBinding {
    @NonNull
    public final ScrollView boE;
    @NonNull
    public final ImageView boF;
    @NonNull
    public final TextView boG;
    @NonNull
    public final View boH;
    @NonNull
    public final View boI;

    protected fy(DataBindingComponent dataBindingComponent, View view, int i, ScrollView scrollView, ImageView imageView, TextView textView, View view2, View view3) {
        super(dataBindingComponent, view, i);
        this.boE = scrollView;
        this.boF = imageView;
        this.boG = textView;
        this.boH = view2;
        this.boI = view3;
    }
}
