package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.dialog.f;

/* compiled from: RateUsDialogBinding */
public abstract class ahg extends ViewDataBinding {
    @NonNull
    public final TextView bFS;
    @NonNull
    public final TextView bQA;
    @NonNull
    public final TextView bQB;
    @NonNull
    public final ImageView bQC;
    @NonNull
    public final ImageView bQD;
    @NonNull
    public final ImageView bQE;
    @NonNull
    public final ImageView bQF;
    @NonNull
    public final ImageView bQG;
    @Bindable
    protected f bQH;
    @NonNull
    public final TextView bQz;
    @NonNull
    public final LinearLayout bjl;
    @NonNull
    public final FrameLayout brJ;

    public abstract void a(@Nullable f fVar);

    protected ahg(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        super(dataBindingComponent, view, i);
        this.bFS = textView;
        this.bjl = linearLayout;
        this.bQz = textView2;
        this.bQA = textView3;
        this.bQB = textView4;
        this.brJ = frameLayout;
        this.bQC = imageView;
        this.bQD = imageView2;
        this.bQE = imageView3;
        this.bQF = imageView4;
        this.bQG = imageView5;
    }
}
