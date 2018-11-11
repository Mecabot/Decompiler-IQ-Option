package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.fragment.account.security.a.d;

/* compiled from: AccountSecurityResendEmailFragmentBinding */
public abstract class q extends ViewDataBinding {
    @NonNull
    public final TextView bij;
    @NonNull
    public final ImageView bik;
    @NonNull
    public final TextView bil;
    @Bindable
    protected d bim;

    public abstract void a(@Nullable d dVar);

    protected q(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bij = textView;
        this.bik = imageView;
        this.bil = textView2;
    }
}
