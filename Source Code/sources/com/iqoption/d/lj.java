package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.fragment.BalanceSelectionFragment;
import com.iqoption.view.RobotoTextView;

/* compiled from: FragmentBalanceSelectionBinding */
public abstract class lj extends ViewDataBinding {
    @NonNull
    public final LinearLayout bwR;
    @NonNull
    public final RelativeLayout bwS;
    @NonNull
    public final RobotoTextView bwT;
    @NonNull
    public final TextView bwU;
    @NonNull
    public final RelativeLayout bwV;
    @NonNull
    public final RobotoTextView bwW;
    @NonNull
    public final TextView bwX;
    @Bindable
    protected BalanceSelectionFragment bwY;

    public abstract void a(@Nullable BalanceSelectionFragment balanceSelectionFragment);

    protected lj(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, RelativeLayout relativeLayout, RobotoTextView robotoTextView, TextView textView, RelativeLayout relativeLayout2, RobotoTextView robotoTextView2, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bwR = linearLayout;
        this.bwS = relativeLayout;
        this.bwT = robotoTextView;
        this.bwU = textView;
        this.bwV = relativeLayout2;
        this.bwW = robotoTextView2;
        this.bwX = textView2;
    }
}
