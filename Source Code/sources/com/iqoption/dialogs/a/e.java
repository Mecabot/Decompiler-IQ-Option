package com.iqoption.dialogs.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: FragmentBottomSheetBinding */
public abstract class e extends ViewDataBinding {
    @NonNull
    public final CoordinatorLayout bHC;
    @NonNull
    public final View bqo;
    @NonNull
    public final FrameLayout ckT;

    protected e(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, CoordinatorLayout coordinatorLayout, View view2) {
        super(dataBindingComponent, view, i);
        this.ckT = frameLayout;
        this.bHC = coordinatorLayout;
        this.bqo = view2;
    }
}
