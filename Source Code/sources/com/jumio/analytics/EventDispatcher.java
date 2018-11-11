package com.jumio.analytics;

import java.util.Collection;

public interface EventDispatcher {
    void dispatchEvents(Collection<AnalyticsEvent> collection);
}
