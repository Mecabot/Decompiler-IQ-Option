package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.fragment.dialog.whatsnew.a;
import com.iqoption.view.RobotoTextView;

/* compiled from: GifWhatsNewDialogBinding */
public abstract class vj extends ViewDataBinding {
    @NonNull
    public final WebView bHS;
    @NonNull
    public final RobotoTextView bHT;
    @NonNull
    public final TextView bHU;
    @NonNull
    public final ImageView bll;
    @Bindable
    protected a bln;

    protected vj(DataBindingComponent dataBindingComponent, View view, int i, WebView webView, ImageView imageView, RobotoTextView robotoTextView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bHS = webView;
        this.bll = imageView;
        this.bHT = robotoTextView;
        this.bHU = textView;
    }
}
