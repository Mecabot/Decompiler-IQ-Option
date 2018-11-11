package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.iqoption.fragment.account.security.phone.b;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.SoftKeyboardEditText;
import com.iqoption.widget.CountDownProgressBar;

/* compiled from: AccountSecurityConfirmCodeFragmentBinding */
public abstract class c extends ViewDataBinding {
    @NonNull
    public final TextView bhA;
    @NonNull
    public final ConfirmButtonView bhF;
    @NonNull
    public final ConfirmButtonView bhG;
    @NonNull
    public final SoftKeyboardEditText bhH;
    @NonNull
    public final TextView bhI;
    @NonNull
    public final CountDownProgressBar bhJ;
    @NonNull
    public final ConfirmButtonView bhK;
    @Bindable
    protected b bhL;

    public abstract void a(@Nullable b bVar);

    protected c(DataBindingComponent dataBindingComponent, View view, int i, ConfirmButtonView confirmButtonView, ConfirmButtonView confirmButtonView2, SoftKeyboardEditText softKeyboardEditText, TextView textView, TextView textView2, CountDownProgressBar countDownProgressBar, ConfirmButtonView confirmButtonView3) {
        super(dataBindingComponent, view, i);
        this.bhF = confirmButtonView;
        this.bhG = confirmButtonView2;
        this.bhH = softKeyboardEditText;
        this.bhI = textView;
        this.bhA = textView2;
        this.bhJ = countDownProgressBar;
        this.bhK = confirmButtonView3;
    }
}
