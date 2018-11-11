package com.iqoption.core.ui.navigation;

import android.arch.lifecycle.GeneratedAdapter;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MethodCallsLogger;

public class LifecycleBackListener_LifecycleAdapter implements GeneratedAdapter {
    final LifecycleBackListener bbO;

    LifecycleBackListener_LifecycleAdapter(LifecycleBackListener lifecycleBackListener) {
        this.bbO = lifecycleBackListener;
    }

    public void a(LifecycleOwner lifecycleOwner, Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        Object obj = methodCallsLogger != null ? 1 : null;
        if (!z) {
            if (event == Event.ON_START) {
                if (obj == null || methodCallsLogger.b("register", 1)) {
                    this.bbO.register();
                }
            } else if (event == Event.ON_STOP) {
                if (obj == null || methodCallsLogger.b("unregister", 1)) {
                    this.bbO.unregister();
                }
            }
        }
    }
}
