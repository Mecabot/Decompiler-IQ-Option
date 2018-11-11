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

/* compiled from: InstrumentTypeBottomSheetItemBinding */
public abstract class vt extends ViewDataBinding {
    @NonNull
    public final FormattedTextView blr;

    protected vt(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView) {
        super(dataBindingComponent, view, i);
        this.blr = formattedTextView;
    }

    @NonNull
    public static vt J(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return J(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static vt J(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (vt) DataBindingUtil.inflate(layoutInflater, R.layout.instrument_type_bottom_sheet_item, viewGroup, z, dataBindingComponent);
    }
}
