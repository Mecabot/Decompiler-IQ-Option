package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.iqoption.view.RobotoTextView;

/* compiled from: FragmentMarketIsOpenBinding */
public abstract class on extends ViewDataBinding {
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final RobotoTextView brQ;
    @NonNull
    public final FrameLayout bxe;
    @NonNull
    public final LinearLayout bxi;

    protected on(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bxe = frameLayout;
        this.blV = frameLayout2;
        this.bxi = linearLayout;
        this.brQ = robotoTextView;
    }
}
