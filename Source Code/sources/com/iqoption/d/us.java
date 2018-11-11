package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import com.iqoption.view.drumview.recyclerviewpager.RecyclerViewPager;
import com.rd.PageIndicatorView;

/* compiled from: FragmentWithdrawVerifyBinding */
public abstract class us extends ViewDataBinding {
    @NonNull
    public final LinearLayout bHp;
    @NonNull
    public final PageIndicatorView bHq;
    @NonNull
    public final RecyclerViewPager bHr;

    protected us(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, PageIndicatorView pageIndicatorView, RecyclerViewPager recyclerViewPager) {
        super(dataBindingComponent, view, i);
        this.bHp = linearLayout;
        this.bHq = pageIndicatorView;
        this.bHr = recyclerViewPager;
    }
}
