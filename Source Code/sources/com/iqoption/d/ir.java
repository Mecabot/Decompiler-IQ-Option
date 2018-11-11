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
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.x.R;

/* compiled from: DialogMarginAddOnPositionBinding */
public abstract class ir extends ViewDataBinding {
    @NonNull
    public final TextView blE;
    @NonNull
    public final MaxSizeCardViewLayout bmb;
    @NonNull
    public final TextView brN;

    protected ir(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, MaxSizeCardViewLayout maxSizeCardViewLayout) {
        super(dataBindingComponent, view, i);
        this.blE = textView;
        this.brN = textView2;
        this.bmb = maxSizeCardViewLayout;
    }

    @NonNull
    public static ir w(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return w(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ir w(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (ir) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_margin_add_on_position, viewGroup, z, dataBindingComponent);
    }
}
