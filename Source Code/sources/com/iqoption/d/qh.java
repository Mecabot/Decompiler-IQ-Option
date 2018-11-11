package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* compiled from: FragmentProTraderWebBinding */
public abstract class qh extends ViewDataBinding {
    @NonNull
    public final aki bAG;
    @NonNull
    public final FrameLayout bAH;
    @NonNull
    public final WebView bAI;

    protected qh(DataBindingComponent dataBindingComponent, View view, int i, aki aki, FrameLayout frameLayout, WebView webView) {
        super(dataBindingComponent, view, i);
        this.bAG = aki;
        setContainedBinding(this.bAG);
        this.bAH = frameLayout;
        this.bAI = webView;
    }
}
