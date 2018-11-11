package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.iqoption.view.scroll.TurnOffNestedScrollView;

/* compiled from: DepositPageOldBinding */
public abstract class gz extends ViewDataBinding {
    @NonNull
    public final ImageView boF;
    @NonNull
    public final TextView boG;
    @NonNull
    public final Guideline bqE;
    @NonNull
    public final Space bqF;
    @NonNull
    public final Guideline bqG;
    @NonNull
    public final LinearLayout bqH;
    @NonNull
    public final TurnOffNestedScrollView bqI;

    protected gz(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, Guideline guideline, Space space, Guideline guideline2, TextView textView, LinearLayout linearLayout, TurnOffNestedScrollView turnOffNestedScrollView) {
        super(dataBindingComponent, view, i);
        this.boF = imageView;
        this.bqE = guideline;
        this.bqF = space;
        this.bqG = guideline2;
        this.boG = textView;
        this.bqH = linearLayout;
        this.bqI = turnOffNestedScrollView;
    }
}
