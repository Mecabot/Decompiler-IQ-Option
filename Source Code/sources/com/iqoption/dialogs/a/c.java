package com.iqoption.dialogs.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeConstraintLayout;

/* compiled from: DialogSimpleBinding */
public abstract class c extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView aip;
    @NonNull
    public final FrameLayout awS;
    @NonNull
    public final TextView blj;
    @NonNull
    public final MaxSizeConstraintLayout btF;
    @NonNull
    public final TextView ckR;
    @NonNull
    public final TextView ckS;

    protected c(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, MaxSizeConstraintLayout maxSizeConstraintLayout, TextView textView3, FrameLayout frameLayout, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.ckR = textView;
        this.ckS = textView2;
        this.btF = maxSizeConstraintLayout;
        this.blj = textView3;
        this.awS = frameLayout;
        this.aip = textView4;
        this.agA = textView5;
    }
}
