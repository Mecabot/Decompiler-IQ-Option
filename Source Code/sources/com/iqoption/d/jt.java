package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: DialogTradeOnPracticeBinding */
public abstract class jt extends ViewDataBinding {
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final ImageView btH;
    @NonNull
    public final FrameLayout btI;
    @NonNull
    public final RobotoTextView btJ;
    @NonNull
    public final TextView buz;

    protected jt(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, RobotoTextView robotoTextView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.btH = imageView;
        this.bjF = frameLayout;
        this.btI = frameLayout2;
        this.btJ = robotoTextView;
        this.buz = textView;
    }
}
