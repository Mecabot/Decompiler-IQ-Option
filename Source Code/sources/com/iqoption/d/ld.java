package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;

/* compiled from: FragmentAccountSecurityPasscodeBinding */
public abstract class ld extends ViewDataBinding {
    @NonNull
    public final LinearLayout aOX;
    @NonNull
    public final kd bwA;
    @NonNull
    public final kd bwB;
    @NonNull
    public final TextView bwC;
    @NonNull
    public final FrameLayout bwD;
    @NonNull
    public final TextSwitcher bwE;
    @NonNull
    public final LinearLayout bwF;
    @Bindable
    protected PasscodeFragment bwG;
    @NonNull
    public final LinearLayout bwd;
    @NonNull
    public final FrameLayout bwt;
    @NonNull
    public final TextView bwu;
    @NonNull
    public final kb bwv;
    @NonNull
    public final kd bww;
    @NonNull
    public final kd bwx;
    @NonNull
    public final kd bwy;
    @NonNull
    public final kd bwz;

    public abstract void a(@Nullable PasscodeFragment passcodeFragment);

    protected ld(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, kb kbVar, kd kdVar, kd kdVar2, kd kdVar3, kd kdVar4, kd kdVar5, kd kdVar6, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, TextSwitcher textSwitcher, LinearLayout linearLayout3) {
        super(dataBindingComponent, view, i);
        this.bwu = textView;
        this.bwv = kbVar;
        setContainedBinding(this.bwv);
        this.bww = kdVar;
        setContainedBinding(this.bww);
        this.bwx = kdVar2;
        setContainedBinding(this.bwx);
        this.bwy = kdVar3;
        setContainedBinding(this.bwy);
        this.bwz = kdVar4;
        setContainedBinding(this.bwz);
        this.bwA = kdVar5;
        setContainedBinding(this.bwA);
        this.bwB = kdVar6;
        setContainedBinding(this.bwB);
        this.bwd = linearLayout;
        this.bwC = textView2;
        this.aOX = linearLayout2;
        this.bwt = frameLayout;
        this.bwD = frameLayout2;
        this.bwE = textSwitcher;
        this.bwF = linearLayout3;
    }
}
