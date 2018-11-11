package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

/* compiled from: FragmentRedirectWebPaymentBinding */
public abstract class ac extends ViewDataBinding {
    @NonNull
    public final ImageView bTH;
    @NonNull
    public final WebView bqN;

    protected ac(DataBindingComponent dataBindingComponent, View view, int i, WebView webView, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bqN = webView;
        this.bTH = imageView;
    }
}
