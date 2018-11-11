package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentWithdrawCompleteBinding */
public abstract class uk extends ViewDataBinding {
    @NonNull
    public final TextView bGX;
    @NonNull
    public final ImageView bGY;
    @NonNull
    public final TextView bGZ;

    protected uk(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bGX = textView;
        this.bGY = imageView;
        this.bGZ = textView2;
    }

    @NonNull
    public static uk F(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return F(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static uk F(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (uk) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_withdraw_complete, viewGroup, z, dataBindingComponent);
    }
}
