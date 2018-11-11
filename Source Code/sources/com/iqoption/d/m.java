package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.iqoption.fragment.account.security.a.a;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.SoftKeyboardEditText;

/* compiled from: AccountSecurityEmailConfirmFragmentBinding */
public abstract class m extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bia;
    @NonNull
    public final SoftKeyboardEditText bib;
    @Bindable
    protected a bic;

    public abstract void a(@Nullable a aVar);

    protected m(DataBindingComponent dataBindingComponent, View view, int i, ConfirmButtonView confirmButtonView, SoftKeyboardEditText softKeyboardEditText) {
        super(dataBindingComponent, view, i);
        this.bia = confirmButtonView;
        this.bib = softKeyboardEditText;
    }
}
