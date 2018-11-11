package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.iqoption.fragment.account.security.touchId.c;
import com.iqoption.view.ProgressSwitchView;

/* compiled from: AccountSecurityTurnOnTouchIdFragmentBinding */
public abstract class u extends ViewDataBinding {
    @NonNull
    public final ProgressSwitchView bip;
    @NonNull
    public final TextView biq;
    @NonNull
    public final TextView bit;
    @Bindable
    protected c biu;

    public abstract void a(@Nullable c cVar);

    protected u(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ProgressSwitchView progressSwitchView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bit = textView;
        this.bip = progressSwitchView;
        this.biq = textView2;
    }
}
