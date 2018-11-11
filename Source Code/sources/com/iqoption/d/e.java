package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.iqoption.fragment.account.security.sms.b;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: AccountSecurityConfirmPhone2stepAuthFragmentBinding */
public abstract class e extends ViewDataBinding {
    @NonNull
    public final TextView bhA;
    @NonNull
    public final ConfirmButtonView bhP;
    @Bindable
    protected b bhQ;

    public abstract void a(@Nullable b bVar);

    protected e(DataBindingComponent dataBindingComponent, View view, int i, ConfirmButtonView confirmButtonView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bhP = confirmButtonView;
        this.bhA = textView;
    }
}
