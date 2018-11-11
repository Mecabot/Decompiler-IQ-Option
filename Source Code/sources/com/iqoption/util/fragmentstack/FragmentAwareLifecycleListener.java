package com.iqoption.util.fragmentstack;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0007J\b\u0010\u0010\u001a\u00020\nH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, aXE = {"Lcom/iqoption/util/fragmentstack/FragmentAwareLifecycleListener;", "Landroid/arch/lifecycle/LifecycleObserver;", "fm", "Landroid/support/v4/app/FragmentManager;", "(Landroid/support/v4/app/FragmentManager;)V", "activeFragmentListener", "Lcom/iqoption/util/fragmentstack/ActiveFragmentStackChangeListener;", "getFm", "()Landroid/support/v4/app/FragmentManager;", "addFragmentVisibilityChangeListener", "", "fragment", "Landroid/support/v4/app/Fragment;", "listener", "Lcom/iqoption/util/fragmentstack/FragmentVisibilityChangeListener;", "start", "stop", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FragmentAwareLifecycleListener.kt */
public final class FragmentAwareLifecycleListener implements LifecycleObserver {
    private final FragmentManager bbS;
    private a dwT;

    public FragmentAwareLifecycleListener(FragmentManager fragmentManager) {
        h.e(fragmentManager, "fm");
        this.bbS = fragmentManager;
    }

    @OnLifecycleEvent(R = Event.ON_CREATE)
    public final void start() {
        this.dwT = new a(this.bbS);
        this.bbS.addOnBackStackChangedListener(this.dwT);
    }

    @OnLifecycleEvent(R = Event.ON_DESTROY)
    public final void stop() {
        this.bbS.removeOnBackStackChangedListener(this.dwT);
    }

    public final void a(Fragment fragment, c cVar) {
        h.e(fragment, "fragment");
        h.e(cVar, "listener");
        a aVar = this.dwT;
        if (aVar != null) {
            aVar.a(fragment, cVar);
        }
    }
}
