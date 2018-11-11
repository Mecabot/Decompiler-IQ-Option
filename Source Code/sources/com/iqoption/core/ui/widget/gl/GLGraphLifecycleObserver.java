package com.iqoption.core.ui.widget.gl;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, aXE = {"Lcom/iqoption/core/ui/widget/gl/GLGraphLifecycleObserver;", "Landroid/arch/lifecycle/LifecycleObserver;", "view", "Lcom/iqoption/core/ui/widget/gl/GLGraphView;", "(Lcom/iqoption/core/ui/widget/gl/GLGraphView;)V", "getView", "()Lcom/iqoption/core/ui/widget/gl/GLGraphView;", "pause", "", "resume", "core_release"})
/* compiled from: GLGraphLifecycleObserver.kt */
public final class GLGraphLifecycleObserver implements LifecycleObserver {
    private final b beB;

    @OnLifecycleEvent(R = Event.ON_START)
    public final void resume() {
        this.beB.onResume();
    }

    @OnLifecycleEvent(R = Event.ON_STOP)
    public final void pause() {
        this.beB.onPause();
    }
}
