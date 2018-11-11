package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView2;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: DepositCardBackSideBinding */
public abstract class fu extends ViewDataBinding {
    @NonNull
    public final CardView2 boi;
    @NonNull
    public final TextView boj;
    @NonNull
    public final View bok;
    @NonNull
    public final EditText bol;
    @NonNull
    public final FrameLayout bom;

    protected fu(DataBindingComponent dataBindingComponent, View view, int i, CardView2 cardView2, TextView textView, View view2, EditText editText, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.boi = cardView2;
        this.boj = textView;
        this.bok = view2;
        this.bol = editText;
        this.bom = frameLayout;
    }
}
