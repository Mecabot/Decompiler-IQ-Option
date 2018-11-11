package com.iqoption.core.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

/* compiled from: TermsFragmentBinding */
public abstract class c extends ViewDataBinding {
    @NonNull
    public final LinearLayout aOX;
    @NonNull
    public final WebView aOY;
    @NonNull
    public final a aOZ;

    protected c(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, WebView webView, a aVar) {
        super(dataBindingComponent, view, i);
        this.aOX = linearLayout;
        this.aOY = webView;
        this.aOZ = aVar;
        setContainedBinding(this.aOZ);
    }
}
