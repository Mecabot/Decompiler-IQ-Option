package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: BottomSheetItemBinding */
public abstract class bg extends ViewDataBinding {
    @NonNull
    public final FormattedTextView blr;

    protected bg(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView) {
        super(dataBindingComponent, view, i);
        this.blr = formattedTextView;
    }

    @NonNull
    public static bg b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return b(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static bg b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (bg) DataBindingUtil.inflate(layoutInflater, R.layout.bottom_sheet_item, viewGroup, z, dataBindingComponent);
    }
}
