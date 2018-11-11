package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.iqoption.fragment.account.security.sms.c;
import com.iqoption.view.ProgressSwitchView;

/* compiled from: AccountSecurityTurnOn2stepAuthFragmentBinding */
public abstract class s extends ViewDataBinding {
    @NonNull
    public final TextView bio;
    @NonNull
    public final ProgressSwitchView bip;
    @NonNull
    public final TextView biq;
    @NonNull
    public final TextView bir;
    @Bindable
    protected c bis;

    public abstract void a(@Nullable c cVar);

    protected s(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ProgressSwitchView progressSwitchView, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.bio = textView;
        this.bip = progressSwitchView;
        this.biq = textView2;
        this.bir = textView3;
    }
}
