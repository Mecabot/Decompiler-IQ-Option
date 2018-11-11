package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: ClosedPortfolioItemBinding */
public abstract class fm extends ViewDataBinding {
    @NonNull
    public final ImageView afU;
    @NonNull
    public final ConstraintLayout bmK;
    @NonNull
    public final TextView bnL;
    @NonNull
    public final TextView bnM;
    @NonNull
    public final TextView bnN;
    @NonNull
    public final ContentLoadingProgressBar bnO;
    @NonNull
    public final RobotoTextView bnP;
    @NonNull
    public final RobotoTextView bnQ;

    protected fm(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, ContentLoadingProgressBar contentLoadingProgressBar, RobotoTextView robotoTextView, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.afU = imageView;
        this.bnL = textView;
        this.bmK = constraintLayout;
        this.bnM = textView2;
        this.bnN = textView3;
        this.bnO = contentLoadingProgressBar;
        this.bnP = robotoTextView;
        this.bnQ = robotoTextView2;
    }

    @NonNull
    public static fm i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static fm i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (fm) DataBindingUtil.inflate(layoutInflater, R.layout.closed_portfolio_item, viewGroup, z, dataBindingComponent);
    }
}
