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
import com.iqoption.fragment.account.security.touchId.a;

/* compiled from: FragmentAccountSecurityPasscodeErrorBinding */
public abstract class lf extends ViewDataBinding {
    @NonNull
    public final LinearLayout aOX;
    @NonNull
    public final TextView bwI;
    @NonNull
    public final TextView bwJ;
    @Bindable
    protected a bwK;
    @NonNull
    public final FrameLayout bwt;

    public abstract void a(@Nullable a aVar);

    protected lf(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.aOX = linearLayout;
        this.bwt = frameLayout;
        this.bwI = textView;
        this.bwJ = textView2;
    }
}
