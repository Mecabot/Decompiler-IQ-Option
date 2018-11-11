package com.iqoption.core.ui.widget.gl;

import android.arch.lifecycle.GeneratedAdapter;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MethodCallsLogger;

public class GLGraphSurfaceLifecycleObserver_LifecycleAdapter implements GeneratedAdapter {
    final GLGraphSurfaceLifecycleObserver beE;

    GLGraphSurfaceLifecycleObserver_LifecycleAdapter(GLGraphSurfaceLifecycleObserver gLGraphSurfaceLifecycleObserver) {
        this.beE = gLGraphSurfaceLifecycleObserver;
    }

    public void a(LifecycleOwner lifecycleOwner, Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        Object obj = methodCallsLogger != null ? 1 : null;
        if (!z) {
            if (event == Event.ON_START) {
                if (obj == null || methodCallsLogger.b("resume", 1)) {
                    this.beE.resume();
                }
            } else if (event == Event.ON_STOP) {
                if (obj == null || methodCallsLogger.b("pause", 1)) {
                    this.beE.pause();
                }
            }
        }
    }
}
