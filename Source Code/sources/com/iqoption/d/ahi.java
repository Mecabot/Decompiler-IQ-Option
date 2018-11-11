package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelClosedBinding */
public abstract class ahi extends ViewDataBinding {
    @NonNull
    public final ImageView bQI;
    @NonNull
    public final RobotoTextView bQJ;

    protected ahi(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bQI = imageView;
        this.bQJ = robotoTextView;
    }

    @Nullable
    public static ahi f(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ahi f(@NonNull LayoutInflater layoutInflater, @Nullable DataBindingComponent dataBindingComponent) {
        return (ahi) DataBindingUtil.inflate(layoutInflater, R.layout.right_panel_closed, null, false, dataBindingComponent);
    }
}
