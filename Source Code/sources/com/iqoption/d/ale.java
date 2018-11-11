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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: VerifySideItemBinding */
public abstract class ale extends ViewDataBinding {
    @NonNull
    public final TextView bTZ;
    @NonNull
    public final ImageView bUa;
    @NonNull
    public final RelativeLayout bUb;
    @NonNull
    public final TextView bUc;
    @NonNull
    public final LinearLayout bUd;

    protected ale(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, RelativeLayout relativeLayout, TextView textView2, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.bTZ = textView;
        this.bUa = imageView;
        this.bUb = relativeLayout;
        this.bUc = textView2;
        this.bUd = linearLayout;
    }

    @NonNull
    public static ale aB(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return aB(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ale aB(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (ale) DataBindingUtil.inflate(layoutInflater, R.layout.verify_side_item, viewGroup, z, dataBindingComponent);
    }
}
