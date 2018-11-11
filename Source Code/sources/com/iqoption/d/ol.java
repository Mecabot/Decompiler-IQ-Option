package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: FragmentMarginNotAddedBinding */
public abstract class ol extends ViewDataBinding {
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final TextView brN;
    @NonNull
    public final FrameLayout bxe;
    @NonNull
    public final LinearLayout bxi;
    @NonNull
    public final View byZ;
    @NonNull
    public final RobotoTextView bza;

    protected ol(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, View view2, FrameLayout frameLayout2, LinearLayout linearLayout, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bxe = frameLayout;
        this.brN = textView;
        this.byZ = view2;
        this.blV = frameLayout2;
        this.bxi = linearLayout;
        this.bza = robotoTextView;
    }
}
