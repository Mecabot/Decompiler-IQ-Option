package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;

/* compiled from: FragmentMktOnOpenCreatedBinding */
public abstract class or extends ViewDataBinding {
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final TextView brN;
    @NonNull
    public final RobotoTextView brQ;
    @NonNull
    public final FrameLayout bxe;
    @NonNull
    public final LinearLayout bxi;
    @NonNull
    public final View byZ;
    @NonNull
    public final RobotoTextView bzc;
    @NonNull
    public final TextView bzd;

    protected or(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, TextView textView, View view2, FrameLayout frameLayout2, LinearLayout linearLayout, RobotoTextView robotoTextView, TextView textView2, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.bxe = frameLayout;
        this.brN = textView;
        this.byZ = view2;
        this.blV = frameLayout2;
        this.bxi = linearLayout;
        this.bzc = robotoTextView;
        this.bzd = textView2;
        this.brQ = robotoTextView2;
    }
}
