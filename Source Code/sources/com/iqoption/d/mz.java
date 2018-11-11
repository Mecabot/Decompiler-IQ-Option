package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.TextView;

/* compiled from: FragmentKycGdprBinding */
public abstract class mz extends ViewDataBinding {
    @NonNull
    public final wp bxE;
    @NonNull
    public final wr bxz;
    @NonNull
    public final CheckBox byn;
    @NonNull
    public final TextView byo;
    @NonNull
    public final TextView byp;
    @NonNull
    public final WebView byq;

    protected mz(DataBindingComponent dataBindingComponent, View view, int i, CheckBox checkBox, TextView textView, TextView textView2, WebView webView, wr wrVar, wp wpVar) {
        super(dataBindingComponent, view, i);
        this.byn = checkBox;
        this.byo = textView;
        this.byp = textView2;
        this.byq = webView;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxE = wpVar;
        setContainedBinding(this.bxE);
    }
}
