package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: PerformVerifyFooterBinding */
public abstract class ade extends ViewDataBinding {
    @NonNull
    public final LinearLayout bNV;
    @NonNull
    public final TextView bNW;
    @NonNull
    public final ContentLoadingProgressBar bNX;

    protected ade(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, TextView textView, ContentLoadingProgressBar contentLoadingProgressBar) {
        super(dataBindingComponent, view, i);
        this.bNV = linearLayout;
        this.bNW = textView;
        this.bNX = contentLoadingProgressBar;
    }

    @NonNull
    public static ade ai(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return ai(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ade ai(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (ade) DataBindingUtil.inflate(layoutInflater, R.layout.perform_verify_footer, viewGroup, z, dataBindingComponent);
    }
}
