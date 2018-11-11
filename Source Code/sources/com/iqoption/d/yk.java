package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.dto.ToastEntity;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: LocalToastLayoutBinding */
public abstract class yk extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bKJ;
    @NonNull
    public final RobotoTextView bKK;
    @NonNull
    public final View bKL;
    @NonNull
    public final ImageView bKM;
    @Bindable
    protected ToastEntity bKN;
    @NonNull
    public final LinearLayout bjl;

    public abstract void d(@Nullable ToastEntity toastEntity);

    protected yk(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, LinearLayout linearLayout, RobotoTextView robotoTextView2, View view2, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bKJ = robotoTextView;
        this.bjl = linearLayout;
        this.bKK = robotoTextView2;
        this.bKL = view2;
        this.bKM = imageView;
    }

    @Nullable
    public ToastEntity aam() {
        return this.bKN;
    }

    @NonNull
    public static yk O(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return O(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static yk O(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (yk) DataBindingUtil.inflate(layoutInflater, R.layout.local_toast_layout, viewGroup, z, dataBindingComponent);
    }
}
