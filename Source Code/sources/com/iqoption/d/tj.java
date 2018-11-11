package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentVerifyDetailsBinding */
public abstract class tj extends ViewDataBinding {
    @NonNull
    public final Button bFq;
    @NonNull
    public final TextView bFr;
    @NonNull
    public final TextView bFs;
    @NonNull
    public final TextView bFt;
    @NonNull
    public final LinearLayout bFu;
    @NonNull
    public final ImageView bFv;
    @NonNull
    public final TextView bFw;
    @NonNull
    public final View bFx;

    protected tj(DataBindingComponent dataBindingComponent, View view, int i, Button button, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, ImageView imageView, TextView textView4, View view2) {
        super(dataBindingComponent, view, i);
        this.bFq = button;
        this.bFr = textView;
        this.bFs = textView2;
        this.bFt = textView3;
        this.bFu = linearLayout;
        this.bFv = imageView;
        this.bFw = textView4;
        this.bFx = view2;
    }

    @NonNull
    public static tj D(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return D(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static tj D(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (tj) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_verify_details, viewGroup, z, dataBindingComponent);
    }
}
