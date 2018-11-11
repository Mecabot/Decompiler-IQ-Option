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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DialogWarningBinding */
public abstract class jx extends ViewDataBinding {
    @NonNull
    public final RelativeLayout blB;
    @NonNull
    public final ImageView blw;
    @NonNull
    public final RobotoTextView buC;
    @NonNull
    public final TextView buD;

    protected jx(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RobotoTextView robotoTextView, TextView textView, RelativeLayout relativeLayout) {
        super(dataBindingComponent, view, i);
        this.blw = imageView;
        this.buC = robotoTextView;
        this.buD = textView;
        this.blB = relativeLayout;
    }

    @NonNull
    public static jx z(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return z(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static jx z(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (jx) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_warning, viewGroup, z, dataBindingComponent);
    }
}
