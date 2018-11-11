package com.jumio.analytics.agents;

import com.jumio.analytics.EventDispatcher;
import com.jumio.analytics.Filter;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.commons.log.Log;

public class FixedRateQuotaAgent extends FixedRateAgent {
    private static final int QUOTA_DEFAULT = 20;
    public final int mEventQueueQuota;

    public FixedRateQuotaAgent() {
        this.mEventQueueQuota = 20;
        String str = JumioAnalytics.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("new FixedRateQuotaAgent(): quota is ");
        stringBuilder.append(this.mEventQueueQuota);
        Log.v(str, stringBuilder.toString());
    }

    public FixedRateQuotaAgent(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Quota must be >0!");
        }
        this.mEventQueueQuota = i;
        String str = JumioAnalytics.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("new FixedRateQuotaAgent(): quota is ");
        stringBuilder.append(this.mEventQueueQuota);
        Log.v(str, stringBuilder.toString());
    }

    public FixedRateQuotaAgent(EventDispatcher eventDispatcher) {
        this.mEventQueueQuota = 20;
        String str = JumioAnalytics.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("new FixedRateQuotaAgent(): quota is ");
        stringBuilder.append(this.mEventQueueQuota);
        Log.v(str, stringBuilder.toString());
        setEventDispatcher(eventDispatcher);
    }

    public FixedRateQuotaAgent(EventDispatcher eventDispatcher, Filter filter) {
        this(eventDispatcher);
        this.mFilter = filter;
    }

    protected void eventEnqueued() {
        if (this.mRequestQueue.size() >= this.mEventQueueQuota) {
            String str = JumioAnalytics.LOGTAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Quota trigger (");
            stringBuilder.append(this.mRequestQueue.size());
            stringBuilder.append(" >= ");
            stringBuilder.append(this.mEventQueueQuota);
            stringBuilder.append("), starting dispatch");
            Log.d(str, stringBuilder.toString());
            dispatchAndClear();
        }
    }

    public int getQuota() {
        return this.mEventQueueQuota;
    }
}
