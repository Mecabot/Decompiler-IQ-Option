package com.iqoption.core.ui.widget.gl;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, aXE = {"Lcom/iqoption/core/ui/widget/gl/GLGraphSurfaceLifecycleObserver;", "Landroid/arch/lifecycle/LifecycleObserver;", "view", "Lcom/iqoption/core/ui/widget/gl/GLGraphSurfaceView;", "(Lcom/iqoption/core/ui/widget/gl/GLGraphSurfaceView;)V", "getView", "()Lcom/iqoption/core/ui/widget/gl/GLGraphSurfaceView;", "pause", "", "resume", "core_release"})
/* compiled from: GLGraphSurfaceLifecycleObserver.kt */
public final class GLGraphSurfaceLifecycleObserver implements LifecycleObserver {
    private final GLGraphSurfaceView beD;

    public GLGraphSurfaceLifecycleObserver(GLGraphSurfaceView gLGraphSurfaceView) {
        h.e(gLGraphSurfaceView, Promotion.ACTION_VIEW);
        this.beD = gLGraphSurfaceView;
    }

    @OnLifecycleEvent(R = Event.ON_START)
    public final void resume() {
        this.beD.onResume();
    }

    @OnLifecycleEvent(R = Event.ON_STOP)
    public final void pause() {
        this.beD.onPause();
    }
}
