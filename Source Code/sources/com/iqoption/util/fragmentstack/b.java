package com.iqoption.util.fragmentstack;

import android.arch.lifecycle.Observer;
import android.support.v4.app.Fragment;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0011J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0015"}, aXE = {"Lcom/iqoption/util/fragmentstack/FragmentAwareLiveDataObserver;", "T", "Landroid/arch/lifecycle/Observer;", "Lcom/iqoption/util/fragmentstack/FragmentVisibilityChangeListener;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "active", "", "dirtyData", "getFragment", "()Landroid/support/v4/app/Fragment;", "lastValue", "Ljava/lang/Object;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "onCustomChange", "onInvisible", "onVisible", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FragmentAwareLiveDataObserver.kt */
public abstract class b<T> implements Observer<T>, c {
    private boolean active = true;
    private boolean dwU;
    private T dwV;
    private final Fragment fragment;

    public abstract void bI(T t);

    public b(Fragment fragment) {
        h.e(fragment, "fragment");
        this.fragment = fragment;
    }

    public void onChanged(T t) {
        this.dwV = t;
        if (this.active) {
            this.dwU = false;
            bI(t);
            return;
        }
        this.dwU = true;
    }

    public void aGG() {
        this.active = true;
        if (this.dwU) {
            this.dwU = false;
            bI(this.dwV);
        }
    }

    public void aGH() {
        this.active = false;
    }
}
