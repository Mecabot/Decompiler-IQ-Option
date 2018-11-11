package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import com.iqoption.view.TextureVideoView;

/* compiled from: FragmentQuizOnAirDelegateBinding */
public abstract class rn extends ViewDataBinding {
    @NonNull
    public final ImageView axz;
    @NonNull
    public final TextureVideoView bBA;
    @NonNull
    public final TextView bBB;
    @NonNull
    public final View bBs;
    @NonNull
    public final TextView bBt;
    @NonNull
    public final Space bBu;
    @NonNull
    public final ImageView bBv;
    @NonNull
    public final View bBw;
    @NonNull
    public final TextView bBx;
    @NonNull
    public final rr bBy;
    @NonNull
    public final FrameLayout bBz;
    @NonNull
    public final RecyclerView bzb;

    protected rn(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, Space space, ImageView imageView2, RecyclerView recyclerView, View view2, TextView textView2, rr rrVar, View view3, FrameLayout frameLayout, TextureVideoView textureVideoView, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.axz = imageView;
        this.bBt = textView;
        this.bBu = space;
        this.bBv = imageView2;
        this.bzb = recyclerView;
        this.bBw = view2;
        this.bBx = textView2;
        this.bBy = rrVar;
        setContainedBinding(this.bBy);
        this.bBs = view3;
        this.bBz = frameLayout;
        this.bBA = textureVideoView;
        this.bBB = textView3;
    }
}
