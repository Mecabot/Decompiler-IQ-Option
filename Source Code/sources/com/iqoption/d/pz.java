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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.fragment.bx;
import com.iqoption.view.RobotoEditText;
import com.iqoption.view.RobotoTextView;
import com.iqoption.widget.SmallNumPad;

/* compiled from: FragmentPendingChooserBinding */
public abstract class pz extends ViewDataBinding {
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final RelativeLayout bAj;
    @NonNull
    public final ImageView bAk;
    @NonNull
    public final LinearLayout bAl;
    @NonNull
    public final RobotoTextView bAm;
    @NonNull
    public final TextView bAn;
    @NonNull
    public final ImageView bAo;
    @NonNull
    public final SmallNumPad bAp;
    @NonNull
    public final ImageView bAq;
    @NonNull
    public final RobotoEditText bAr;
    @Bindable
    protected bx bAs;
    @NonNull
    public final FrameLayout blV;

    public abstract void a(@Nullable bx bxVar);

    protected pz(DataBindingComponent dataBindingComponent, View view, int i, RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, RobotoTextView robotoTextView, TextView textView, ImageView imageView2, SmallNumPad smallNumPad, ImageView imageView3, RobotoEditText robotoEditText) {
        super(dataBindingComponent, view, i);
        this.bAj = relativeLayout;
        this.bAk = imageView;
        this.avm = linearLayout;
        this.blV = frameLayout;
        this.bAl = linearLayout2;
        this.bAm = robotoTextView;
        this.bAn = textView;
        this.bAo = imageView2;
        this.bAp = smallNumPad;
        this.bAq = imageView3;
        this.bAr = robotoEditText;
    }
}
