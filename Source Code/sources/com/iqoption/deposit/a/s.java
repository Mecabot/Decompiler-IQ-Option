package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/* compiled from: FragmentDepositPerformLightBinding */
public abstract class s extends ViewDataBinding {
    @NonNull
    public final ImageView bTH;
    @NonNull
    public final bg bYY;
    @NonNull
    public final LinearLayout bYZ;
    @NonNull
    public final EditText bZa;
    @NonNull
    public final TextView bZb;
    @NonNull
    public final TextView bZc;
    @NonNull
    public final bk bZd;
    @NonNull
    public final FrameLayout bZe;
    @NonNull
    public final TextView bZf;
    @NonNull
    public final ScrollView bZg;
    @NonNull
    public final RecyclerView bZh;
    @NonNull
    public final TextView bZi;
    @NonNull
    public final bz bZj;
    @NonNull
    public final View bZk;

    protected s(DataBindingComponent dataBindingComponent, View view, int i, bg bgVar, LinearLayout linearLayout, EditText editText, TextView textView, TextView textView2, bk bkVar, FrameLayout frameLayout, TextView textView3, ScrollView scrollView, RecyclerView recyclerView, TextView textView4, ImageView imageView, bz bzVar, View view2) {
        super(dataBindingComponent, view, i);
        this.bYY = bgVar;
        setContainedBinding(this.bYY);
        this.bYZ = linearLayout;
        this.bZa = editText;
        this.bZb = textView;
        this.bZc = textView2;
        this.bZd = bkVar;
        setContainedBinding(this.bZd);
        this.bZe = frameLayout;
        this.bZf = textView3;
        this.bZg = scrollView;
        this.bZh = recyclerView;
        this.bZi = textView4;
        this.bTH = imageView;
        this.bZj = bzVar;
        setContainedBinding(this.bZj);
        this.bZk = view2;
    }
}
