package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: WithdrawFieldConstructorBinding */
public abstract class amk extends ViewDataBinding {
    @NonNull
    public final TextView bUP;

    protected amk(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bUP = textView;
    }

    @NonNull
    public static amk aC(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return aC(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static amk aC(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (amk) DataBindingUtil.inflate(layoutInflater, R.layout.withdraw_field_constructor, viewGroup, z, dataBindingComponent);
    }
}
