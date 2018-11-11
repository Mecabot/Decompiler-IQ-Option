package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.Space;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: FragmentOtnLeadingBoardProfileBinding */
public abstract class pl extends ViewDataBinding {
    @NonNull
    public final FrameLayout bzL;
    @NonNull
    public final pn bzQ;
    @NonNull
    public final pp bzR;
    @NonNull
    public final pr bzS;
    @NonNull
    public final Space bzT;
    @NonNull
    public final Space bzU;
    @NonNull
    public final Space bzV;
    @NonNull
    public final Space bzW;
    @NonNull
    public final pv bzX;
    @NonNull
    public final px bzY;

    protected pl(DataBindingComponent dataBindingComponent, View view, int i, pn pnVar, pp ppVar, pr prVar, FrameLayout frameLayout, Space space, Space space2, Space space3, Space space4, pv pvVar, px pxVar) {
        super(dataBindingComponent, view, i);
        this.bzQ = pnVar;
        setContainedBinding(this.bzQ);
        this.bzR = ppVar;
        setContainedBinding(this.bzR);
        this.bzS = prVar;
        setContainedBinding(this.bzS);
        this.bzL = frameLayout;
        this.bzT = space;
        this.bzU = space2;
        this.bzV = space3;
        this.bzW = space4;
        this.bzX = pvVar;
        setContainedBinding(this.bzX);
        this.bzY = pxVar;
        setContainedBinding(this.bzY);
    }
}
