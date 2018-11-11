package com.jumio.analytics.agents;

import com.jumio.analytics.AnalyticsEvent;
import com.jumio.analytics.EventDispatcher;
import com.jumio.analytics.Filter;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.commons.log.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class EventAgent {
    protected final String LOGTAG = JumioAnalytics.LOGTAG;
    private final ExecutorService mDispatchExecutor = Executors.newSingleThreadExecutor();
    protected EventDispatcher mEventDispatcher;
    protected Filter mFilter;
    private boolean mLocked = true;
    protected final Queue<AnalyticsEvent> mRequestQueue;
    protected final Object queueLock = new Object();

    private class DispatchRunner implements Callable<Void> {
        private Collection<AnalyticsEvent> mEvents;

        private DispatchRunner(Collection<AnalyticsEvent> collection) {
            this.mEvents = collection;
        }

        public Void call() {
            try {
                Log.v(JumioAnalytics.LOGTAG, "EventDispatcher.dispatchEvents()");
                EventAgent.this.mEventDispatcher.dispatchEvents(this.mEvents);
            } catch (Throwable e) {
                Log.w(JumioAnalytics.LOGTAG, "Exception while event dispatch", e);
                synchronized (EventAgent.this.queueLock) {
                    EventAgent.this.mRequestQueue.addAll(this.mEvents);
                }
            }
            return null;
        }
    }

    protected void eventEnqueued() {
    }

    public abstract void flush();

    public abstract void start();

    public EventAgent(Queue<AnalyticsEvent> queue) {
        this.mRequestQueue = queue;
        this.mFilter = null;
    }

    public final void enqueue(AnalyticsEvent analyticsEvent) {
        if (this.mFilter == null || !this.mFilter.contains(analyticsEvent.getEventType())) {
            synchronized (this.queueLock) {
                String str = JumioAnalytics.LOGTAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("enqueue ");
                stringBuilder.append(analyticsEvent.toString());
                Log.d(str, stringBuilder.toString());
                this.mRequestQueue.add(analyticsEvent);
                eventEnqueued();
            }
        }
    }

    public final void setEventDispatcher(EventDispatcher eventDispatcher) {
        String str = JumioAnalytics.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set new EventDispatcher: ");
        stringBuilder.append(eventDispatcher);
        Log.v(str, stringBuilder.toString());
        this.mEventDispatcher = eventDispatcher;
    }

    public final int getQueueSize() {
        int size;
        synchronized (this.queueLock) {
            size = this.mRequestQueue.size();
        }
        return size;
    }

    public final boolean isLocked() {
        return this.mLocked;
    }

    public final void setLocked(boolean z) {
        this.mLocked = z;
    }

    protected void dispatchAndClear() {
        if (this.mLocked) {
            Log.w(JumioAnalytics.LOGTAG, "cannot dispatch - agent is locked!");
        } else if (this.mRequestQueue != null && this.mRequestQueue.size() > 0) {
            synchronized (this.queueLock) {
                if (this.mEventDispatcher != null) {
                    Collection asList = Arrays.asList(this.mRequestQueue.toArray(new AnalyticsEvent[getQueueSize()]));
                    this.mRequestQueue.clear();
                    this.mDispatchExecutor.submit(new DispatchRunner(asList));
                } else {
                    Log.w(JumioAnalytics.LOGTAG, "cannot dispatchAndClear - dispatcher is null!");
                }
            }
        }
    }

    public void addFinishTask(Runnable runnable) {
        synchronized (this.queueLock) {
            if (!(this.mEventDispatcher == null || runnable == null)) {
                this.mDispatchExecutor.submit(runnable);
            }
        }
    }

    public void stop() {
        if (this.mRequestQueue != null) {
            this.mRequestQueue.clear();
        }
    }

    public Filter getFilter() {
        return this.mFilter;
    }
}
