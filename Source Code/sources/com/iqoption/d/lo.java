package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.x.R;

/* compiled from: FragmentDarkDialogBinding */
public abstract class lo extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView aip;
    @NonNull
    public final FrameLayout awS;
    @NonNull
    public final MaxSizeCardViewLayout bmb;
    @NonNull
    public final TextView bxm;
    @NonNull
    public final TextView bxn;

    protected lo(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, MaxSizeCardViewLayout maxSizeCardViewLayout, FrameLayout frameLayout, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bxm = textView;
        this.bxn = textView2;
        this.bmb = maxSizeCardViewLayout;
        this.awS = frameLayout;
        this.aip = textView3;
        this.agA = textView4;
    }

    @NonNull
    public static lo A(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return A(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static lo A(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (lo) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_dark_dialog, viewGroup, z, dataBindingComponent);
    }
}
