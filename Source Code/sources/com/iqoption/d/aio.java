package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.fragment.rightpanel.b.c;
import com.iqoption.view.BuyNewDialogView;
import com.iqoption.view.ConfirmDialogView;
import com.iqoption.view.RobotoTextView;

/* compiled from: RightPanelDelegateTurboBinaryBinding */
public abstract class aio extends ViewDataBinding {
    @NonNull
    public final TextView bRM;
    @NonNull
    public final TextView bRN;
    @NonNull
    public final FrameLayout bRh;
    @NonNull
    public final ImageView bRi;
    @NonNull
    public final BuyNewDialogView bRp;
    @NonNull
    public final FrameLayout bSR;
    @NonNull
    public final RobotoTextView bSS;
    @Bindable
    protected c bST;
    @NonNull
    public final ConfirmDialogView bSd;
    @NonNull
    public final TextView bSe;
    @NonNull
    public final ImageView bSg;
    @NonNull
    public final FrameLayout bSi;
    @NonNull
    public final LinearLayout bSj;
    @NonNull
    public final TextView bwO;
    @NonNull
    public final RobotoTextView bwP;

    public abstract void a(@Nullable c cVar);

    protected aio(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, FrameLayout frameLayout, TextView textView2, ImageView imageView, TextView textView3, RobotoTextView robotoTextView, BuyNewDialogView buyNewDialogView, ConfirmDialogView confirmDialogView, TextView textView4, FrameLayout frameLayout2, ImageView imageView2, RobotoTextView robotoTextView2, FrameLayout frameLayout3, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.bwO = textView;
        this.bRh = frameLayout;
        this.bRM = textView2;
        this.bRi = imageView;
        this.bRN = textView3;
        this.bwP = robotoTextView;
        this.bRp = buyNewDialogView;
        this.bSd = confirmDialogView;
        this.bSe = textView4;
        this.bSR = frameLayout2;
        this.bSg = imageView2;
        this.bSS = robotoTextView2;
        this.bSi = frameLayout3;
        this.bSj = linearLayout;
    }
}
