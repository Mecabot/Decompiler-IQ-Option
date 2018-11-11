package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: DepositPaymentAuthorizationPageBinding */
public abstract class hb extends ViewDataBinding {
    @NonNull
    public final TextView boG;
    @NonNull
    public final View boH;
    @NonNull
    public final View boI;
    @NonNull
    public final LinearLayout bqL;
    @NonNull
    public final TextView bqM;
    @NonNull
    public final WebView bqN;

    protected hb(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, View view2, View view3, WebView webView) {
        super(dataBindingComponent, view, i);
        this.bqL = linearLayout;
        this.bqM = textView;
        this.boG = textView2;
        this.boH = view2;
        this.boI = view3;
        this.bqN = webView;
    }
}
