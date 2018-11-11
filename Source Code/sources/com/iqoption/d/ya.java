package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import com.iqoption.view.RobotoTextView;

/* compiled from: LeftMenuItemProfileBinding */
public abstract class ya extends ViewDataBinding {
    @NonNull
    public final ImageView bAh;
    @NonNull
    public final RobotoTextView bKE;
    @NonNull
    public final RobotoTextView bKF;

    protected ya(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RobotoTextView robotoTextView, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.bAh = imageView;
        this.bKE = robotoTextView;
        this.bKF = robotoTextView2;
    }
}
