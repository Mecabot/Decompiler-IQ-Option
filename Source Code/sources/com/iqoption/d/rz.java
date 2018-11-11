package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.chat.fragment.BadgeView;

/* compiled from: FragmentRoomBinding */
public abstract class rz extends ViewDataBinding {
    @NonNull
    public final BadgeView aHb;
    @NonNull
    public final ImageView awN;
    @NonNull
    public final FrameLayout bBO;
    @NonNull
    public final FrameLayout bBP;
    @NonNull
    public final RecyclerView bBQ;
    @NonNull
    public final FrameLayout bBR;
    @NonNull
    public final FrameLayout bBS;
    @NonNull
    public final LinearLayout bmC;

    protected rz(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, BadgeView badgeView, RecyclerView recyclerView, FrameLayout frameLayout3, LinearLayout linearLayout, FrameLayout frameLayout4) {
        super(dataBindingComponent, view, i);
        this.bBO = frameLayout;
        this.awN = imageView;
        this.bBP = frameLayout2;
        this.aHb = badgeView;
        this.bBQ = recyclerView;
        this.bBR = frameLayout3;
        this.bmC = linearLayout;
        this.bBS = frameLayout4;
    }
}
