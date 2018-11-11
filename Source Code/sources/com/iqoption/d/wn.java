package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.view.RobotoEditText;
import com.iqoption.view.RobotoTextView;
import com.iqoption.widget.NumPad;
import com.iqoption.x.R;

/* compiled from: KeyboardTpslBinding */
public abstract class wn extends ViewDataBinding {
    @NonNull
    public final RobotoEditText bIr;
    @NonNull
    public final RobotoTextView bJM;
    @NonNull
    public final LinearLayout bJN;
    @NonNull
    public final ImageSwitcher bJO;
    @NonNull
    public final ImageView bJP;
    @NonNull
    public final ImageView bJQ;
    @NonNull
    public final NumPad bxR;

    protected wn(DataBindingComponent dataBindingComponent, View view, int i, RobotoEditText robotoEditText, RobotoTextView robotoTextView, LinearLayout linearLayout, NumPad numPad, ImageSwitcher imageSwitcher, ImageView imageView, ImageView imageView2) {
        super(dataBindingComponent, view, i);
        this.bIr = robotoEditText;
        this.bJM = robotoTextView;
        this.bJN = linearLayout;
        this.bxR = numPad;
        this.bJO = imageSwitcher;
        this.bJP = imageView;
        this.bJQ = imageView2;
    }

    @NonNull
    public static wn N(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return N(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static wn N(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (wn) DataBindingUtil.inflate(layoutInflater, R.layout.keyboard_tpsl, viewGroup, z, dataBindingComponent);
    }
}
