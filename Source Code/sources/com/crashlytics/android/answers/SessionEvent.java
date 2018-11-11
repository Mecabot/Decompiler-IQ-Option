package com.crashlytics.android.answers;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

final class SessionEvent {
    public final ab sT;
    public final Type sU;
    public final Map<String, String> sV;
    public final String sW;
    public final Map<String, Object> sX;
    public final String sY;
    public final Map<String, Object> sZ;
    private String ta;
    public final long timestamp;

    enum Type {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    static class a {
        final Type sU;
        Map<String, String> sV = null;
        String sW = null;
        Map<String, Object> sX = null;
        String sY = null;
        Map<String, Object> sZ = null;
        final long timestamp = System.currentTimeMillis();

        public a(Type type) {
            this.sU = type;
        }

        public a j(Map<String, String> map) {
            this.sV = map;
            return this;
        }

        public a k(Map<String, Object> map) {
            this.sX = map;
            return this;
        }

        public SessionEvent a(ab abVar) {
            return new SessionEvent(abVar, this.timestamp, this.sU, this.sV, this.sW, this.sX, this.sY, this.sZ);
        }
    }

    public static a a(Type type, Activity activity) {
        return new a(type).j(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    public static a k(long j) {
        return new a(Type.INSTALL).j(Collections.singletonMap("installedAt", String.valueOf(j)));
    }

    public static a aN(String str) {
        return new a(Type.CRASH).j(Collections.singletonMap("sessionId", str));
    }

    public static a l(String str, String str2) {
        return aN(str).k(Collections.singletonMap("exceptionName", str2));
    }

    private SessionEvent(ab abVar, long j, Type type, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.sT = abVar;
        this.timestamp = j;
        this.sU = type;
        this.sV = map;
        this.sW = str;
        this.sX = map2;
        this.sY = str2;
        this.sZ = map3;
    }

    public String toString() {
        if (this.ta == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append(": ");
            stringBuilder.append("timestamp=");
            stringBuilder.append(this.timestamp);
            stringBuilder.append(", type=");
            stringBuilder.append(this.sU);
            stringBuilder.append(", details=");
            stringBuilder.append(this.sV);
            stringBuilder.append(", customType=");
            stringBuilder.append(this.sW);
            stringBuilder.append(", customAttributes=");
            stringBuilder.append(this.sX);
            stringBuilder.append(", predefinedType=");
            stringBuilder.append(this.sY);
            stringBuilder.append(", predefinedAttributes=");
            stringBuilder.append(this.sZ);
            stringBuilder.append(", metadata=[");
            stringBuilder.append(this.sT);
            stringBuilder.append("]]");
            this.ta = stringBuilder.toString();
        }
        return this.ta;
    }
}
