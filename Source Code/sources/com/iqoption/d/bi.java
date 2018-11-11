package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: BottomSheetMessageBinding */
public abstract class bi extends ViewDataBinding {
    @NonNull
    public final View blp;
    @NonNull
    public final RobotoTextView bls;

    protected bi(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, View view2) {
        super(dataBindingComponent, view, i);
        this.bls = robotoTextView;
        this.blp = view2;
    }

    @NonNull
    public static bi c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static bi c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (bi) DataBindingUtil.inflate(layoutInflater, R.layout.bottom_sheet_message, viewGroup, z, dataBindingComponent);
    }
}
