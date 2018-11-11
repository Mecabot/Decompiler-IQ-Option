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
import com.iqoption.fragment.dialog.f;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.scoreboard.BalanceView;

/* compiled from: DialogCongratOtnEmissionExecutedBinding */
public abstract class il extends ViewDataBinding {
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final ImageView bmW;
    @NonNull
    public final FrameLayout brJ;
    @NonNull
    public final LinearLayout brR;
    @NonNull
    public final RobotoTextView brS;
    @NonNull
    public final LinearLayout brT;
    @NonNull
    public final RobotoTextView brU;
    @NonNull
    public final TextView brV;
    @NonNull
    public final RobotoTextView brW;
    @NonNull
    public final RobotoTextView brX;
    @NonNull
    public final ImageView brY;
    @NonNull
    public final ImageView brZ;
    @NonNull
    public final TextView bsa;
    @NonNull
    public final FrameLayout bsb;
    @NonNull
    public final BalanceView bsc;
    @Bindable
    protected f bsd;

    public abstract void a(@Nullable f fVar);

    protected il(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, RobotoTextView robotoTextView, FrameLayout frameLayout, LinearLayout linearLayout2, RobotoTextView robotoTextView2, TextView textView, ImageView imageView, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4, ImageView imageView2, ImageView imageView3, TextView textView2, FrameLayout frameLayout2, FrameLayout frameLayout3, BalanceView balanceView) {
        super(dataBindingComponent, view, i);
        this.brR = linearLayout;
        this.brS = robotoTextView;
        this.blV = frameLayout;
        this.brT = linearLayout2;
        this.brU = robotoTextView2;
        this.brV = textView;
        this.bmW = imageView;
        this.brW = robotoTextView3;
        this.brX = robotoTextView4;
        this.brY = imageView2;
        this.brZ = imageView3;
        this.bsa = textView2;
        this.brJ = frameLayout2;
        this.bsb = frameLayout3;
        this.bsc = balanceView;
    }
}
