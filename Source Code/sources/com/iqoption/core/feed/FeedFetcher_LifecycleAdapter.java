package com.iqoption.core.feed;

import android.arch.lifecycle.GeneratedAdapter;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MethodCallsLogger;

public class FeedFetcher_LifecycleAdapter implements GeneratedAdapter {
    final FeedFetcher aQq;

    FeedFetcher_LifecycleAdapter(FeedFetcher feedFetcher) {
        this.aQq = feedFetcher;
    }

    public void a(LifecycleOwner lifecycleOwner, Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        Object obj = methodCallsLogger != null ? 1 : null;
        if (!z) {
            if (event == Event.ON_START) {
                if (obj == null || methodCallsLogger.b("onStart", 1)) {
                    this.aQq.onStart();
                }
            } else if (event == Event.ON_STOP) {
                if (obj == null || methodCallsLogger.b("onStop", 1)) {
                    this.aQq.onStop();
                }
            }
        }
    }
}
