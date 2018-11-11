package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.fragment.dialog.nps.a;

/* compiled from: NpsCompletedFragmentBinding */
public abstract class abo extends ViewDataBinding {
    @NonNull
    public final TextView aip;
    @NonNull
    public final ImageView bBI;
    @NonNull
    public final FrameLayout bMr;
    @NonNull
    public final ConstraintLayout bMs;
    @Bindable
    protected a bMt;
    @NonNull
    public final ImageView bmu;

    public abstract void a(@Nullable a aVar);

    protected abo(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, FrameLayout frameLayout, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bBI = imageView;
        this.bMr = frameLayout;
        this.bmu = imageView2;
        this.bMs = constraintLayout;
        this.aip = textView;
    }
}
