package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.CryptoBumperView;
import com.iqoption.x.R;

/* compiled from: ItemCryptoAssetBinding */
public abstract class vz extends ViewDataBinding {
    @NonNull
    public final ImageView aEt;
    @NonNull
    public final TextView avo;
    @NonNull
    public final FrameLayout bAL;
    @NonNull
    public final CryptoBumperView bJg;
    @NonNull
    public final View bJh;
    @NonNull
    public final FrameLayout bJi;
    @NonNull
    public final ImageView bJj;

    protected vz(DataBindingComponent dataBindingComponent, View view, int i, CryptoBumperView cryptoBumperView, View view2, ImageView imageView, FrameLayout frameLayout, TextView textView, ImageView imageView2, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.bJg = cryptoBumperView;
        this.bJh = view2;
        this.aEt = imageView;
        this.bJi = frameLayout;
        this.avo = textView;
        this.bJj = imageView2;
        this.bAL = frameLayout2;
    }

    @NonNull
    public static vz K(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return K(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static vz K(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (vz) DataBindingUtil.inflate(layoutInflater, R.layout.item_crypto_asset, viewGroup, z, dataBindingComponent);
    }
}
