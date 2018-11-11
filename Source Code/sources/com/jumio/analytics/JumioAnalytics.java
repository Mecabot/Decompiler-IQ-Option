package com.jumio.analytics;

import android.content.Context;
import android.support.annotation.Nullable;
import com.jumio.analytics.agents.EventAgent;
import com.jumio.analytics.agents.FixedRateQuotaAgent;
import com.jumio.analytics.http.HttpEventDispatcher;
import com.jumio.commons.log.Log;
import com.jumio.core.network.ApiCall.DynamicProvider;
import java.util.UUID;

public class JumioAnalytics {
    public static final String LOGTAG = "Analytics";
    @Nullable
    private static EventAgent mAgent = null;
    private static boolean mEnabled = true;
    private static String mScanReference;
    private static UUID mSessionId;

    public static void start() {
        Filter configuration = getConfiguration();
        Log.d(LOGTAG, "## Starting JumioAnalytics module ##");
        mAgent = new FixedRateQuotaAgent(null, configuration);
        newSessionId();
    }

    private static Filter getConfiguration() {
        return new Filter().disable(MobileEvents.EVENTTYPE_RAW_TOUCH).disable(MobileEvents.EVENTTYPE_NETWORKCALL);
    }

    public static void add(AnalyticsEvent analyticsEvent) {
        if (!mEnabled) {
            return;
        }
        if (analyticsEvent.getSessionId() == null) {
            String str = LOGTAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Discarding event (sessionID == null) : ");
            stringBuilder.append(analyticsEvent.toString());
            Log.w(str, stringBuilder.toString());
            return;
        }
        if (mAgent == null) {
            start();
        }
        mAgent.enqueue(analyticsEvent);
        if (analyticsEvent.mEventType == MobileEvents.EVENTTYPE_SDKLIFECYCLE && !analyticsEvent.getPayload().getValue().equals(DismissType.INSTANCE_CREATED.toString())) {
            Log.v(LOGTAG, "-- event was SDKLIFECYCLE -> flush() events");
            mAgent.flush();
        }
    }

    public static void shutdown(Runnable runnable) {
        Log.d(LOGTAG, "## Shutting down JumioAnalytics module ##");
        if (!mEnabled || (mAgent != null && mAgent.isLocked())) {
            new Thread(runnable).start();
        }
        if (mAgent != null) {
            mAgent.flush();
            mAgent.addFinishTask(runnable);
            mAgent.addFinishTask(new Runnable() {
                public void run() {
                    JumioAnalytics.mSessionId = null;
                    JumioAnalytics.mScanReference = null;
                    Log.d(JumioAnalytics.LOGTAG, "## Shutting down JumioAnalytics module complete ##");
                }
            });
            mAgent = null;
            return;
        }
        mSessionId = null;
        mScanReference = null;
        Log.d(LOGTAG, "## Shutting down JumioAnalytics module complete ##");
    }

    private static UUID newSessionId() {
        mSessionId = null;
        mSessionId = UUID.randomUUID();
        String str = LOGTAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create new session Id: ");
        stringBuilder.append(mSessionId.toString());
        Log.d(str, stringBuilder.toString());
        return mSessionId;
    }

    public static UUID getSessionId() {
        if (mSessionId == null) {
            Log.w(LOGTAG, "getSessionId(): uninitialized sessionID!");
        }
        return mSessionId;
    }

    public static String getScanReference() {
        return mScanReference;
    }

    public static void setScanReference(String str) {
        mScanReference = str;
    }

    public static void flush() {
        if (mAgent != null) {
            Log.d(LOGTAG, "forced flush");
            mAgent.flush();
        }
    }

    public static void unlock(Context context, DynamicProvider dynamicProvider, String str, String str2) {
        Log.d(LOGTAG, "Unlock Analytics");
        if (mAgent == null) {
            Log.w(LOGTAG, "unlock(): JumioAnalytics not initialized. Call start now!");
            start();
        }
        mEnabled = true;
        mAgent.setEventDispatcher(new HttpEventDispatcher(context, dynamicProvider, str, str2));
        mAgent.setLocked(false);
    }

    public static void disable() {
        Log.d(LOGTAG, "disable Analytics");
        mEnabled = false;
        if (mAgent != null) {
            mAgent.stop();
        }
    }

    public static void allowEvent(int i, boolean z) {
        if (mAgent != null) {
            if (z) {
                mAgent.getFilter().enable(i);
            } else {
                mAgent.getFilter().disable(i);
            }
        }
    }
}
