package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: ItemWelcomeTrendingBinding */
public abstract class wj extends ViewDataBinding {
    @NonNull
    public final TextView bAu;
    @NonNull
    public final TextView bJv;
    @NonNull
    public final RelativeLayout bJw;
    @NonNull
    public final ImageView bkT;
    @NonNull
    public final TextView bkV;

    protected wj(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout) {
        super(dataBindingComponent, view, i);
        this.bkT = imageView;
        this.bAu = textView;
        this.bkV = textView2;
        this.bJv = textView3;
        this.bJw = relativeLayout;
    }

    @NonNull
    public static wj M(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return M(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static wj M(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (wj) DataBindingUtil.inflate(layoutInflater, R.layout.item_welcome_trending, viewGroup, z, dataBindingComponent);
    }
}
