package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.fragment.bt;
import com.iqoption.view.RobotoTextView;

/* compiled from: DialogOtnCommisionChangedBinding */
public abstract class iv extends ViewDataBinding {
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final FrameLayout brJ;
    @NonNull
    public final LinearLayout bsD;
    @NonNull
    public final TextView bsE;
    @NonNull
    public final RobotoTextView bsF;
    @NonNull
    public final RobotoTextView bsG;
    @NonNull
    public final LinearLayout bsH;
    @NonNull
    public final TextView bsI;
    @NonNull
    public final RobotoTextView bsJ;
    @NonNull
    public final RobotoTextView bsK;
    @NonNull
    public final RobotoTextView bsL;
    @Bindable
    protected bt bsM;

    public abstract void a(@Nullable bt btVar);

    protected iv(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, TextView textView, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, LinearLayout linearLayout3, TextView textView2, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.avm = linearLayout;
        this.blV = frameLayout;
        this.bsD = linearLayout2;
        this.bsE = textView;
        this.bsF = robotoTextView;
        this.bsG = robotoTextView2;
        this.bsH = linearLayout3;
        this.bsI = textView2;
        this.bsJ = robotoTextView3;
        this.bsK = robotoTextView4;
        this.bsL = robotoTextView5;
        this.brJ = frameLayout2;
    }
}
