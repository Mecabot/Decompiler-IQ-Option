package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.iqoption.fragment.account.security.phone.e;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.SoftKeyboardEditText;

/* compiled from: AccountSecurityPhoneNumberFragmentBinding */
public abstract class o extends ViewDataBinding {
    @NonNull
    public final SoftKeyboardEditText bif;
    @NonNull
    public final ConfirmButtonView big;
    @Bindable
    protected e bih;

    public abstract void a(@Nullable e eVar);

    protected o(DataBindingComponent dataBindingComponent, View view, int i, SoftKeyboardEditText softKeyboardEditText, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.bif = softKeyboardEditText;
        this.big = confirmButtonView;
    }
}
