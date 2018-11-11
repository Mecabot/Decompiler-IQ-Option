package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DialogOtnExpectationBinding */
public abstract class ix extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final LinearLayout bjl;
    @NonNull
    public final ImageView blw;
    @NonNull
    public final TextView bmE;
    @NonNull
    public final ImageView bsO;
    @NonNull
    public final ImageView bsP;
    @NonNull
    public final ImageView bsQ;
    @NonNull
    public final ImageView bsR;
    @NonNull
    public final TextView bsS;
    @NonNull
    public final TextView bsT;
    @NonNull
    public final TextView bsU;
    @NonNull
    public final RobotoTextView bsV;
    @NonNull
    public final TextView bsW;
    @NonNull
    public final TextView bsX;
    @NonNull
    public final TextView bsY;
    @NonNull
    public final LinearLayout bsZ;
    @NonNull
    public final TextView bta;
    @NonNull
    public final TextView btb;

    protected ix(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RobotoTextView robotoTextView, TextView textView6, TextView textView7, TextView textView8, LinearLayout linearLayout2, TextView textView9, TextView textView10) {
        super(dataBindingComponent, view, i);
        this.bsO = imageView;
        this.bsP = imageView2;
        this.bsQ = imageView3;
        this.bsR = imageView4;
        this.blw = imageView5;
        this.bjl = linearLayout;
        this.bmE = textView;
        this.agA = textView2;
        this.bsS = textView3;
        this.bsT = textView4;
        this.bsU = textView5;
        this.bsV = robotoTextView;
        this.bsW = textView6;
        this.bsX = textView7;
        this.bsY = textView8;
        this.bsZ = linearLayout2;
        this.bta = textView9;
        this.btb = textView10;
    }

    @NonNull
    public static ix x(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return x(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ix x(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (ix) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_otn_expectation, viewGroup, z, dataBindingComponent);
    }
}
