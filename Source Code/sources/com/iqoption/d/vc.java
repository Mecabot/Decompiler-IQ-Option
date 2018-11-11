package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.view.RobotoEditText;

/* compiled from: FragmentWithdrawalCryptoWalletBinding */
public abstract class vc extends ViewDataBinding {
    @Nullable
    public final FrameLayout bHA;
    @Nullable
    public final LinearLayout bHB;
    @Nullable
    public final CoordinatorLayout bHC;
    @NonNull
    public final ImageView bHD;
    @NonNull
    public final RobotoEditText bHE;
    @NonNull
    public final View bHF;
    @NonNull
    public final View bHG;
    @NonNull
    public final RobotoEditText bHH;
    @NonNull
    public final LinearLayout bHI;
    @NonNull
    public final TextView bHJ;
    @NonNull
    public final TextView bHK;
    @NonNull
    public final ImageView bHL;
    @NonNull
    public final TextView bHM;
    @NonNull
    public final TextView bHN;
    @NonNull
    public final ProgressBar bly;

    protected vc(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, CoordinatorLayout coordinatorLayout, ProgressBar progressBar, ImageView imageView, RobotoEditText robotoEditText, View view2, View view3, RobotoEditText robotoEditText2, LinearLayout linearLayout2, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4) {
        super(dataBindingComponent, view, i);
        this.bHA = frameLayout;
        this.bHB = linearLayout;
        this.bHC = coordinatorLayout;
        this.bly = progressBar;
        this.bHD = imageView;
        this.bHE = robotoEditText;
        this.bHF = view2;
        this.bHG = view3;
        this.bHH = robotoEditText2;
        this.bHI = linearLayout2;
        this.bHJ = textView;
        this.bHK = textView2;
        this.bHL = imageView2;
        this.bHM = textView3;
        this.bHN = textView4;
    }
}
