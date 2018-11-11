package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/* compiled from: FragmentCardPaymentLightBinding */
public abstract class k extends ViewDataBinding {
    @NonNull
    public final ToggleButton bER;
    @NonNull
    public final ImageView bYF;
    @NonNull
    public final ImageView bYJ;
    @NonNull
    public final EditText bYM;
    @NonNull
    public final EditText bYN;
    @NonNull
    public final EditText bYO;
    @NonNull
    public final LinearLayout bYz;
    @NonNull
    public final EditText bon;

    protected k(DataBindingComponent dataBindingComponent, View view, int i, EditText editText, LinearLayout linearLayout, EditText editText2, EditText editText3, EditText editText4, ImageView imageView, ToggleButton toggleButton, ImageView imageView2) {
        super(dataBindingComponent, view, i);
        this.bYM = editText;
        this.bYz = linearLayout;
        this.bon = editText2;
        this.bYN = editText3;
        this.bYO = editText4;
        this.bYF = imageView;
        this.bER = toggleButton;
        this.bYJ = imageView2;
    }
}
