package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.a.r.b;

/* compiled from: PushSettingsGroupItemBinding */
public abstract class ahe extends ViewDataBinding {
    @NonNull
    public final TextView bQs;
    @NonNull
    public final TextView bQu;
    @NonNull
    public final SwitchCompat bQv;
    @NonNull
    public final ProgressBar bQw;
    @NonNull
    public final LinearLayout bQx;
    @Bindable
    protected b bQy;

    protected ahe(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, SwitchCompat switchCompat, ProgressBar progressBar, TextView textView2, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.bQu = textView;
        this.bQv = switchCompat;
        this.bQw = progressBar;
        this.bQs = textView2;
        this.bQx = linearLayout;
    }
}
