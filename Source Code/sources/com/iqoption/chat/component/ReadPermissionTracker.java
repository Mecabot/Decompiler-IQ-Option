package com.iqoption.chat.component;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/chat/component/ReadPermissionTracker;", "Landroid/arch/lifecycle/LifecycleObserver;", "callback", "Lcom/iqoption/chat/component/ReadPermissionTracker$Callback;", "(Lcom/iqoption/chat/component/ReadPermissionTracker$Callback;)V", "checkPermission", "", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ReadPermissionTracker.kt */
public final class ReadPermissionTracker implements LifecycleObserver {
    private final a aEy;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, aXE = {"Lcom/iqoption/chat/component/ReadPermissionTracker$Callback;", "", "onDenied", "", "onGranted", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ReadPermissionTracker.kt */
    public interface a {
        void Pe();

        void Pf();
    }

    public ReadPermissionTracker(a aVar) {
        h.e(aVar, "callback");
        this.aEy = aVar;
    }

    @OnLifecycleEvent(R = Event.ON_START)
    public final void checkPermission() {
        if (com.iqoption.core.ext.a.go("android.permission.READ_EXTERNAL_STORAGE")) {
            this.aEy.Pe();
        } else {
            this.aEy.Pf();
        }
    }
}
