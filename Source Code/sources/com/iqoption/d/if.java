package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.fragment.ap;

/* compiled from: DialogCommisionInfoBinding */
public abstract class if extends ViewDataBinding {
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final FrameLayout brJ;
    @NonNull
    public final TextView brK;
    @Bindable
    protected ap brL;

    public abstract void a(@Nullable ap apVar);

    protected if(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView) {
        super(dataBindingComponent, view, i);
        this.blV = frameLayout;
        this.brJ = frameLayout2;
        this.brK = textView;
    }
}
