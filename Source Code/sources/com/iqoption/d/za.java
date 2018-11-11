package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.feed.feedlist.TagLayout;
import com.iqoption.widget.PreventScrollingTextView;

/* compiled from: MicroArticleFeedBinding */
public abstract class za extends ViewDataBinding {
    @NonNull
    public final TextView bKP;
    @NonNull
    public final PreventScrollingTextView bKS;
    @NonNull
    public final TextView bKT;
    @NonNull
    public final TagLayout bKU;
    @NonNull
    public final zc bLj;
    @NonNull
    public final ze bLk;

    protected za(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, zc zcVar, ze zeVar, PreventScrollingTextView preventScrollingTextView, TextView textView2, TagLayout tagLayout) {
        super(dataBindingComponent, view, i);
        this.bKP = textView;
        this.bLj = zcVar;
        setContainedBinding(this.bLj);
        this.bLk = zeVar;
        setContainedBinding(this.bLk);
        this.bKS = preventScrollingTextView;
        this.bKT = textView2;
        this.bKU = tagLayout;
    }
}
