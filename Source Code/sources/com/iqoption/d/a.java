package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: AccountSecurityConfirmCodeExpiredFragmentBinding */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final TextView bhA;
    @NonNull
    public final TextView bhB;
    @NonNull
    public final ConfirmButtonView bhC;
    @Bindable
    protected com.iqoption.fragment.account.security.phone.a bhD;

    public abstract void a(@Nullable com.iqoption.fragment.account.security.phone.a aVar);

    protected a(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.bhA = textView;
        this.bhB = textView2;
        this.bhC = confirmButtonView;
    }
}
