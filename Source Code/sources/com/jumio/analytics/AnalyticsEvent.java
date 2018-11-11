package com.jumio.analytics;

import java.util.UUID;

public class AnalyticsEvent {
    protected int mEventType;
    protected Payload mPayload;
    protected UUID mSessionId;
    protected final long mTimestamp = System.currentTimeMillis();

    public AnalyticsEvent(int i, UUID uuid, MetaInfo metaInfo) {
        this.mSessionId = uuid;
        this.mEventType = i;
        this.mPayload = new Payload(metaInfo, null);
    }

    public AnalyticsEvent(int i, UUID uuid, String str, MetaInfo metaInfo) {
        this.mEventType = i;
        this.mSessionId = uuid;
        this.mPayload = new Payload(str, metaInfo);
    }

    public String toString() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("AnalyticsEvent ");
        stringBuilder2.append(this.mEventType);
        stringBuilder2.append(" | ");
        stringBuilder2.append(this.mTimestamp);
        stringBuilder2.append(" // ");
        stringBuilder2.append(this.mPayload.getValue());
        if (this.mPayload.getMetaInfo() != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(" | ");
            stringBuilder3.append(this.mPayload.getMetaInfo());
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        return stringBuilder2.toString();
    }

    public int hashCode() {
        return ((((((int) (this.mTimestamp ^ (this.mTimestamp >>> 32))) + 31) * 31) + (this.mSessionId == null ? 0 : this.mSessionId.hashCode())) * 31) + this.mEventType;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof AnalyticsEvent)) {
            return false;
        }
        AnalyticsEvent analyticsEvent = (AnalyticsEvent) obj;
        if (analyticsEvent.mTimestamp == this.mTimestamp && analyticsEvent.mSessionId.equals(this.mSessionId) && analyticsEvent.mEventType == this.mEventType) {
            z = true;
        }
        return z;
    }

    public int getEventType() {
        return this.mEventType;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public Payload getPayload() {
        return this.mPayload;
    }

    public UUID getSessionId() {
        return this.mSessionId;
    }
}
