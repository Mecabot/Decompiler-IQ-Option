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
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DialogClosedDealsItemCfdAggregatedBinding */
public abstract class hz extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bnP;
    @NonNull
    public final ImageView brA;
    @NonNull
    public final RobotoTextView brB;
    @NonNull
    public final RobotoTextView brC;
    @NonNull
    public final RobotoTextView brD;
    @NonNull
    public final RobotoTextView brp;
    @NonNull
    public final RobotoTextView brw;
    @NonNull
    public final RobotoTextView brx;
    @NonNull
    public final RobotoTextView bry;
    @NonNull
    public final TextView brz;

    protected hz(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5, TextView textView, ImageView imageView, RobotoTextView robotoTextView6, RobotoTextView robotoTextView7, RobotoTextView robotoTextView8) {
        super(dataBindingComponent, view, i);
        this.brw = robotoTextView;
        this.brx = robotoTextView2;
        this.brp = robotoTextView3;
        this.bry = robotoTextView4;
        this.bnP = robotoTextView5;
        this.brz = textView;
        this.brA = imageView;
        this.brB = robotoTextView6;
        this.brC = robotoTextView7;
        this.brD = robotoTextView8;
    }

    @NonNull
    public static hz t(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return t(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static hz t(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (hz) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_closed_deals_item_cfd_aggregated, viewGroup, z, dataBindingComponent);
    }
}
