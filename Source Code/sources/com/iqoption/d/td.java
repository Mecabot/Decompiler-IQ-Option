package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewStubProxy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.iqoption.x.R;

/* compiled from: FragmentTutorialBinding */
public abstract class td extends ViewDataBinding {
    @NonNull
    public final ViewStubProxy bEY;
    @NonNull
    public final ImageView bEZ;
    @NonNull
    public final ViewStubProxy bFa;

    protected td(DataBindingComponent dataBindingComponent, View view, int i, ViewStubProxy viewStubProxy, ImageView imageView, ViewStubProxy viewStubProxy2) {
        super(dataBindingComponent, view, i);
        this.bEY = viewStubProxy;
        this.bEZ = imageView;
        this.bFa = viewStubProxy2;
    }

    @NonNull
    public static td B(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return B(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static td B(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (td) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_tutorial, viewGroup, z, dataBindingComponent);
    }
}
