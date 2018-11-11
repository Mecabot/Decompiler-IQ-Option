package com.jumio.analytics.agents;

import com.jumio.analytics.EventDispatcher;
import com.jumio.analytics.Filter;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.commons.log.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FixedRateAgent extends EventAgent implements Runnable {
    private ScheduledFuture<?> mEventChecker;
    private int mSendIntervalMsec;
    private final ScheduledExecutorService scheduler;

    public FixedRateAgent(EventDispatcher eventDispatcher, Filter filter) {
        super(new ConcurrentLinkedQueue());
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.mSendIntervalMsec = 20000;
        this.mEventDispatcher = eventDispatcher;
        start();
        this.mFilter = filter;
    }

    public FixedRateAgent() {
        super(new ConcurrentLinkedQueue());
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.mSendIntervalMsec = 20000;
        this.mEventDispatcher = null;
        start();
    }

    private void initTimedHandler() {
        String str = JumioAnalytics.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("start with fixed rate at P=");
        stringBuilder.append(this.mSendIntervalMsec);
        stringBuilder.append(" ms");
        Log.v(str, stringBuilder.toString());
        if (this.mEventChecker != null) {
            Log.v(JumioAnalytics.LOGTAG, "cancelling old event handler");
            this.mEventChecker.cancel(true);
        }
        this.mEventChecker = this.scheduler.scheduleWithFixedDelay(this, (long) this.mSendIntervalMsec, (long) this.mSendIntervalMsec, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        super.stop();
        if (this.mEventChecker != null && !this.mEventChecker.isCancelled()) {
            this.mEventChecker.cancel(true);
        }
    }

    public void start() {
        initTimedHandler();
    }

    public void flush() {
        Log.d(JumioAnalytics.LOGTAG, "flush() queue");
        if (this.mEventChecker != null) {
            this.mEventChecker.cancel(true);
        }
        synchronized (this.queueLock) {
            if (this.mRequestQueue.isEmpty()) {
                Log.v(JumioAnalytics.LOGTAG, " -- nothing to flush()");
                return;
            }
            dispatchAndClear();
        }
    }

    public void run() {
        if (this.mRequestQueue.size() > 0) {
            String str = JumioAnalytics.LOGTAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("time trigger: dispatch ");
            stringBuilder.append(this.mRequestQueue.size());
            stringBuilder.append(" events");
            Log.d(str, stringBuilder.toString());
            dispatchAndClear();
            return;
        }
        Log.v(JumioAnalytics.LOGTAG, "time trigger: NOOP (no events)");
    }

    public void setSendInterval(int i) {
        this.mSendIntervalMsec = i;
        String str = JumioAnalytics.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set new interval to ");
        stringBuilder.append(i);
        Log.v(str, stringBuilder.toString());
        initTimedHandler();
    }
}
