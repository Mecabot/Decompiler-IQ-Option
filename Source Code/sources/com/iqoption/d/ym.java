package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.feed.feedlist.TagLayout;
import com.iqoption.widget.PreventScrollingTextView;

/* compiled from: MacroArticleFeedBinding */
public abstract class ym extends ViewDataBinding {
    @NonNull
    public final ImageView bKO;
    @NonNull
    public final TextView bKP;
    @NonNull
    public final kr bKQ;
    @NonNull
    public final kv bKR;
    @NonNull
    public final PreventScrollingTextView bKS;
    @NonNull
    public final TextView bKT;
    @NonNull
    public final TagLayout bKU;

    protected ym(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, kr krVar, kv kvVar, PreventScrollingTextView preventScrollingTextView, TextView textView2, TagLayout tagLayout) {
        super(dataBindingComponent, view, i);
        this.bKO = imageView;
        this.bKP = textView;
        this.bKQ = krVar;
        setContainedBinding(this.bKQ);
        this.bKR = kvVar;
        setContainedBinding(this.bKR);
        this.bKS = preventScrollingTextView;
        this.bKT = textView2;
        this.bKU = tagLayout;
    }
}
