package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

/* compiled from: FragmentRedirectWebPaymentLightBinding */
public abstract class ae extends ViewDataBinding {
    @NonNull
    public final ImageView bTH;
    @NonNull
    public final WebView bqN;

    protected ae(DataBindingComponent dataBindingComponent, View view, int i, WebView webView, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bqN = webView;
        this.bTH = imageView;
    }
}
