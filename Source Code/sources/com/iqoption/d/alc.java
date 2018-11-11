package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: VerifySideHintBinding */
public abstract class alc extends ViewDataBinding {
    @NonNull
    public final TextView bTU;
    @NonNull
    public final ImageView bTV;
    @NonNull
    public final TextView bTW;
    @NonNull
    public final TextView bTX;
    @NonNull
    public final LinearLayout bTY;

    protected alc(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.bTU = textView;
        this.bTV = imageView;
        this.bTW = textView2;
        this.bTX = textView3;
        this.bTY = linearLayout;
    }

    @Nullable
    public static alc g(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static alc g(@NonNull LayoutInflater layoutInflater, @Nullable DataBindingComponent dataBindingComponent) {
        return (alc) DataBindingUtil.inflate(layoutInflater, R.layout.verify_side_hint, null, false, dataBindingComponent);
    }
}
