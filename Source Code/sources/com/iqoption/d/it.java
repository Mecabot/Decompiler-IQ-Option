package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.fragment.bo;

/* compiled from: DialogMultiplierConfirmBinding */
public abstract class it extends ViewDataBinding {
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final FrameLayout brJ;
    @NonNull
    public final TextView brN;
    @Bindable
    protected bo bsA;

    public abstract void a(@Nullable bo boVar);

    protected it(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.brN = textView;
        this.blV = frameLayout;
        this.brJ = frameLayout2;
    }
}
