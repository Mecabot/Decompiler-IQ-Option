package com.iqoption.core.ui.navigation;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/core/ui/navigation/LifecycleBackListener;", "Lcom/iqoption/core/ui/navigation/BackListener;", "Landroid/arch/lifecycle/LifecycleObserver;", "controller", "Lcom/iqoption/core/ui/navigation/BackController;", "(Lcom/iqoption/core/ui/navigation/BackController;)V", "register", "", "unregister", "core_release"})
/* compiled from: LifecycleBackListener.kt */
public abstract class LifecycleBackListener implements LifecycleObserver, b {
    private final a bbN;

    public LifecycleBackListener(a aVar) {
        h.e(aVar, "controller");
        this.bbN = aVar;
    }

    @OnLifecycleEvent(R = Event.ON_START)
    public final void register() {
        this.bbN.a(this);
    }

    @OnLifecycleEvent(R = Event.ON_STOP)
    public final void unregister() {
        this.bbN.b(this);
    }
}
