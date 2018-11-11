package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.view.RobotoTextView;

/* compiled from: WhatsNewDepositItemBinding */
public abstract class aly extends ViewDataBinding {
    @NonNull
    public final LinearLayout bUx;
    @NonNull
    public final ImageView bmu;
    @NonNull
    public final RobotoTextView brQ;

    protected aly(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, ImageView imageView, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bUx = linearLayout;
        this.bmu = imageView;
        this.brQ = robotoTextView;
    }
}
