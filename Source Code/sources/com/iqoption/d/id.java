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
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DialogClosedDealsItemDoBinding */
public abstract class id extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bnJ;
    @NonNull
    public final RobotoTextView brD;
    @NonNull
    public final ImageView brG;
    @NonNull
    public final RobotoTextView brH;
    @NonNull
    public final RobotoTextView brI;

    protected id(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4) {
        super(dataBindingComponent, view, i);
        this.brG = imageView;
        this.brH = robotoTextView;
        this.brD = robotoTextView2;
        this.brI = robotoTextView3;
        this.bnJ = robotoTextView4;
    }

    @NonNull
    public static id v(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return v(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static id v(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (id) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_closed_deals_item_do, viewGroup, z, dataBindingComponent);
    }
}
