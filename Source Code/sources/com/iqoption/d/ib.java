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
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: DialogClosedDealsItemCfdBinding */
public abstract class ib extends ViewDataBinding {
    @NonNull
    public final ImageView brA;
    @NonNull
    public final RobotoTextView brB;
    @NonNull
    public final RobotoTextView brC;
    @NonNull
    public final RobotoTextView brD;
    @NonNull
    public final RobotoTextView brE;
    @NonNull
    public final FormattedTextView brF;
    @NonNull
    public final RobotoTextView brw;
    @NonNull
    public final RobotoTextView brx;

    protected ib(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, ImageView imageView, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5, RobotoTextView robotoTextView6, FormattedTextView formattedTextView) {
        super(dataBindingComponent, view, i);
        this.brw = robotoTextView;
        this.brx = robotoTextView2;
        this.brE = robotoTextView3;
        this.brA = imageView;
        this.brB = robotoTextView4;
        this.brC = robotoTextView5;
        this.brD = robotoTextView6;
        this.brF = formattedTextView;
    }

    @NonNull
    public static ib u(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return u(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ib u(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (ib) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_closed_deals_item_cfd, viewGroup, z, dataBindingComponent);
    }
}
