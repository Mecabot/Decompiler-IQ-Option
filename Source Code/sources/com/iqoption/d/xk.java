package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import com.iqoption.view.RobotoTextView;

/* compiled from: LeftMenuItemButtonBinding */
public abstract class xk extends ViewDataBinding {
    @NonNull
    public final AppCompatImageView bKt;
    @NonNull
    public final RobotoTextView bKu;

    protected xk(DataBindingComponent dataBindingComponent, View view, int i, AppCompatImageView appCompatImageView, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bKt = appCompatImageView;
        this.bKu = robotoTextView;
    }
}
