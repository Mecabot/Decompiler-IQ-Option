package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.fragment.bf;

/* compiled from: DialogPortfolioInvestInfoBinding */
public abstract class jf extends ViewDataBinding {
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final FrameLayout brJ;
    @NonNull
    public final TextView bto;
    @Bindable
    protected bf btp;

    public abstract void a(@Nullable bf bfVar);

    protected jf(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.bto = textView;
        this.blV = frameLayout;
        this.brJ = frameLayout2;
    }
}
