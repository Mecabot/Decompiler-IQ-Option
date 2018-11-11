package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.iqoption.view.NumberAnimateRobotoTextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: CfdConfirmDialogViewBinding */
public abstract class bu extends ViewDataBinding {
    @NonNull
    public final RobotoTextView blC;
    @NonNull
    public final NumberAnimateRobotoTextView blN;
    @NonNull
    public final ImageView blO;
    @NonNull
    public final FormattedTextView blP;
    @NonNull
    public final SwitchCompat blQ;
    @NonNull
    public final RelativeLayout blR;
    @NonNull
    public final RobotoTextView blS;
    @NonNull
    public final RobotoTextView blT;

    protected bu(DataBindingComponent dataBindingComponent, View view, int i, NumberAnimateRobotoTextView numberAnimateRobotoTextView, ImageView imageView, FormattedTextView formattedTextView, SwitchCompat switchCompat, RelativeLayout relativeLayout, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3) {
        super(dataBindingComponent, view, i);
        this.blN = numberAnimateRobotoTextView;
        this.blO = imageView;
        this.blP = formattedTextView;
        this.blQ = switchCompat;
        this.blR = relativeLayout;
        this.blS = robotoTextView;
        this.blT = robotoTextView2;
        this.blC = robotoTextView3;
    }
}
