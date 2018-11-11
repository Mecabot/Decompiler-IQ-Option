package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.iqoption.fragment.account.security.phone.c;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: AccountSecurityConfirmPhoneFragmentBinding */
public abstract class g extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bhG;
    @NonNull
    public final ConfirmButtonView bhS;
    @NonNull
    public final FormattedTextView bhT;
    @Bindable
    protected c bhU;

    public abstract void a(@Nullable c cVar);

    protected g(DataBindingComponent dataBindingComponent, View view, int i, ConfirmButtonView confirmButtonView, ConfirmButtonView confirmButtonView2, FormattedTextView formattedTextView) {
        super(dataBindingComponent, view, i);
        this.bhG = confirmButtonView;
        this.bhS = confirmButtonView2;
        this.bhT = formattedTextView;
    }
}
