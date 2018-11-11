package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import com.iqoption.view.scoreboard.OnlineCountBoard;

/* compiled from: OnlineCounterLayoutBinding */
public abstract class abw extends ViewDataBinding {
    @NonNull
    public final OnlineCountBoard bGw;
    @NonNull
    public final LinearLayout bGx;

    protected abw(DataBindingComponent dataBindingComponent, View view, int i, OnlineCountBoard onlineCountBoard, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.bGw = onlineCountBoard;
        this.bGx = linearLayout;
    }
}
