package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.webkit.WebView;

/* compiled from: FragmentKycRisksBinding */
public abstract class ob extends ViewDataBinding {
    @NonNull
    public final WebView EM;
    @NonNull
    public final ContentLoadingProgressBar bnn;
    @NonNull
    public final wr bxz;

    protected ob(DataBindingComponent dataBindingComponent, View view, int i, wr wrVar, ContentLoadingProgressBar contentLoadingProgressBar, WebView webView) {
        super(dataBindingComponent, view, i);
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bnn = contentLoadingProgressBar;
        this.EM = webView;
    }
}
