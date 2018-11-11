package com.jumio.analytics.http;

import android.content.Context;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.jumio.analytics.AnalyticsEvent;
import com.jumio.analytics.EventDispatcher;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.commons.log.Log;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.SimpleApiCall;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class HttpEventDispatcher extends SimpleApiCall<Void> implements EventDispatcher {
    private static final int TIMEOUT_MS = 20000;
    private Collection<AnalyticsEvent> events;

    private class EventTypeComparator implements Comparator<AnalyticsEvent> {
        private EventTypeComparator() {
        }

        public int compare(AnalyticsEvent analyticsEvent, AnalyticsEvent analyticsEvent2) {
            if (analyticsEvent.getEventType() < analyticsEvent2.getEventType()) {
                return -1;
            }
            return analyticsEvent.getEventType() > analyticsEvent2.getEventType() ? 1 : 0;
        }
    }

    protected String getUri() {
        return "analytics/events";
    }

    protected Void parseResponse(String str) {
        return null;
    }

    public HttpEventDispatcher(Context context, DynamicProvider dynamicProvider, String str, String str2) {
        super(context, dynamicProvider, null);
        configure(str, str2);
        setTimeout(TIMEOUT_MS);
    }

    protected void responseReceived(int i, String str, long j, String str2) {
        super.responseReceived(i, str, j, str2);
    }

    /* JADX WARNING: Missing block: B:23:?, code:
            return;
     */
    public void dispatchEvents(java.util.Collection<com.jumio.analytics.AnalyticsEvent> r4) {
        /*
        r3 = this;
        r3.events = r4;
        r0 = "Analytics";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "HttpEventDispatcher Dispatching ";
        r1.append(r2);
        r4 = r4.size();
        r1.append(r4);
        r4 = " events";
        r1.append(r4);
        r4 = r1.toString();
        com.jumio.commons.log.Log.d(r0, r4);
        r4 = r3.isDeviceOffline();	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
        if (r4 == 0) goto L_0x0036;
    L_0x0027:
        r4 = r3.TAG;	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
        r0 = "Device is offline";
        com.jumio.commons.log.Log.w(r4, r0);	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
        r4 = new com.jumio.analytics.DispatchException;	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
        r0 = "Device is offline";
        r4.<init>(r0);	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
        throw r4;	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
    L_0x0036:
        r4 = r3.TAG;	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
        r0 = "execute()";
        com.jumio.commons.log.Log.v(r4, r0);	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
        r3.execute();	 Catch:{ AleKeyUpdateException -> 0x0041 }
        goto L_0x004b;
    L_0x0041:
        r4 = r3.TAG;	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
        r0 = "### ALE key update required. Re-execute call";
        com.jumio.commons.log.Log.i(r4, r0);	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
        r3.execute();	 Catch:{ UnexpectedResponseException -> 0x006a, IOException -> 0x005c, DispatchException -> 0x005a, Exception -> 0x004c }
    L_0x004b:
        return;
    L_0x004c:
        r4 = move-exception;
        r0 = "Analytics";
        r1 = "General exception";
        com.jumio.commons.log.Log.w(r0, r1, r4);
        r0 = new com.jumio.analytics.DispatchException;
        r0.<init>(r4);
        throw r0;
    L_0x005a:
        r4 = move-exception;
        throw r4;
    L_0x005c:
        r4 = move-exception;
        r0 = "Analytics";
        r1 = "Exception while sending!";
        com.jumio.commons.log.Log.w(r0, r1, r4);
        r0 = new com.jumio.analytics.DispatchException;
        r0.<init>(r4);
        throw r0;
    L_0x006a:
        r4 = move-exception;
        r0 = new com.jumio.analytics.DispatchException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r4.getStatusCode();
        r1.append(r2);
        r2 = " -- ";
        r1.append(r2);
        r4 = r4.getMessage();
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.analytics.http.HttpEventDispatcher.dispatchEvents(java.util.Collection):void");
    }

    protected String getRequest() {
        if (this.events == null || this.events.isEmpty()) {
            throw new IllegalArgumentException("event list cannot be empty!");
        }
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        if (JumioAnalytics.getScanReference() != null) {
            jSONObject.put("sessionId", ((AnalyticsEvent) this.events.iterator().next()).getSessionId().toString());
            jSONObject.put("scanReference", JumioAnalytics.getScanReference());
            z = true;
        } else {
            jSONObject.put("sessionId", ((AnalyticsEvent) this.events.iterator().next()).getSessionId().toString());
        }
        Comparator eventTypeComparator = new EventTypeComparator();
        Object arrayList = new ArrayList(this.events);
        Collections.sort(arrayList, eventTypeComparator);
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AnalyticsEvent analyticsEvent = (AnalyticsEvent) it.next();
            JSONObject jSONObject2 = new JSONObject();
            if (analyticsEvent.getEventType() == 307) {
                analyticsEvent.getPayload().getMetaInfo().put("usesScanRef", Boolean.valueOf(z));
            }
            jSONObject2.put("eventType", analyticsEvent.getEventType());
            jSONObject2.put(Param.TIMESTAMP, analyticsEvent.getTimestamp());
            jSONObject2.put("payload", analyticsEvent.getPayload().toJson());
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("events", jSONArray);
        String str = JumioAnalytics.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request body: \n");
        stringBuilder.append(jSONObject.toString(3));
        Log.v(str, stringBuilder.toString());
        return jSONObject.toString();
    }
}
