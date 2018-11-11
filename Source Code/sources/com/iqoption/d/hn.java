package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.Space;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: DialogClosedDealsBinding */
public abstract class hn extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final RecyclerView axw;
    @NonNull
    public final ImageView blw;
    @NonNull
    public final AppBarLayout brd;
    @NonNull
    public final Space bre;
    @NonNull
    public final Space brf;
    @NonNull
    public final CoordinatorLayout brg;
    @NonNull
    public final FrameLayout brh;
    @NonNull
    public final ContentLoadingProgressBar bri;
    @NonNull
    public final FrameLayout brj;
    @NonNull
    public final FrameLayout brk;
    @NonNull
    public final LinearLayout brl;
    @NonNull
    public final TextView brm;
    @NonNull
    public final FrameLayout brn;

    protected hn(DataBindingComponent dataBindingComponent, View view, int i, AppBarLayout appBarLayout, ImageView imageView, Space space, Space space2, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, ContentLoadingProgressBar contentLoadingProgressBar, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, FrameLayout frameLayout4) {
        super(dataBindingComponent, view, i);
        this.brd = appBarLayout;
        this.blw = imageView;
        this.bre = space;
        this.brf = space2;
        this.brg = coordinatorLayout;
        this.brh = frameLayout;
        this.bri = contentLoadingProgressBar;
        this.brj = frameLayout2;
        this.brk = frameLayout3;
        this.brl = linearLayout;
        this.axw = recyclerView;
        this.agA = textView;
        this.brm = textView2;
        this.brn = frameLayout4;
    }

    @NonNull
    public static hn n(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return n(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static hn n(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (hn) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_closed_deals, viewGroup, z, dataBindingComponent);
    }
}
