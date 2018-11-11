package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.iqoption.view.RobotoTextView;

/* compiled from: CommissionViewBinding */
public abstract class fo extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bnR;
    @NonNull
    public final LinearLayout bnS;
    @NonNull
    public final View bnT;
    @NonNull
    public final RobotoTextView bnU;
    @NonNull
    public final RobotoTextView bnV;
    @NonNull
    public final RelativeLayout bnW;
    @NonNull
    public final ImageView bnX;
    @NonNull
    public final RobotoTextView bnY;
    @NonNull
    public final RobotoTextView bnZ;
    @NonNull
    public final LinearLayout boa;

    protected fo(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, LinearLayout linearLayout, View view2, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, RelativeLayout relativeLayout, ImageView imageView, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5, LinearLayout linearLayout2) {
        super(dataBindingComponent, view, i);
        this.bnR = robotoTextView;
        this.bnS = linearLayout;
        this.bnT = view2;
        this.bnU = robotoTextView2;
        this.bnV = robotoTextView3;
        this.bnW = relativeLayout;
        this.bnX = imageView;
        this.bnY = robotoTextView4;
        this.bnZ = robotoTextView5;
        this.boa = linearLayout2;
    }
}
