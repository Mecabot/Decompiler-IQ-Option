package com.facebook.internal;

import android.util.Log;
import com.facebook.LoggingBehavior;
import com.facebook.h;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: Logger */
public class q {
    private static final HashMap<String, String> Ea = new HashMap();
    private final LoggingBehavior Eb;
    private StringBuilder Ec;
    private int priority = 3;
    private final String tag;

    public static synchronized void B(String str, String str2) {
        synchronized (q.class) {
            Ea.put(str, str2);
        }
    }

    public static synchronized void bJ(String str) {
        synchronized (q.class) {
            if (!h.a(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                B(str, "ACCESS_TOKEN_REMOVED");
            }
        }
    }

    public static void a(LoggingBehavior loggingBehavior, String str, String str2) {
        a(loggingBehavior, 3, str, str2);
    }

    public static void a(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        if (h.a(loggingBehavior)) {
            a(loggingBehavior, 3, str, String.format(str2, objArr));
        }
    }

    public static void a(LoggingBehavior loggingBehavior, int i, String str, String str2, Object... objArr) {
        if (h.a(loggingBehavior)) {
            a(loggingBehavior, i, str, String.format(str2, objArr));
        }
    }

    public static void a(LoggingBehavior loggingBehavior, int i, String str, String str2) {
        if (h.a(loggingBehavior)) {
            str2 = bK(str2);
            if (!str.startsWith("FacebookSDK.")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("FacebookSDK.");
                stringBuilder.append(str);
                str = stringBuilder.toString();
            }
            Log.println(i, str, str2);
            if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    private static synchronized String bK(String str) {
        synchronized (q.class) {
            for (Entry entry : Ea.entrySet()) {
                str = str.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return str;
    }

    public q(LoggingBehavior loggingBehavior, String str) {
        x.F(str, "tag");
        this.Eb = loggingBehavior;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FacebookSDK.");
        stringBuilder.append(str);
        this.tag = stringBuilder.toString();
        this.Ec = new StringBuilder();
    }

    public void log() {
        bL(this.Ec.toString());
        this.Ec = new StringBuilder();
    }

    public void bL(String str) {
        a(this.Eb, this.priority, this.tag, str);
    }

    public void append(String str) {
        if (mf()) {
            this.Ec.append(str);
        }
    }

    public void d(String str, Object... objArr) {
        if (mf()) {
            this.Ec.append(String.format(str, objArr));
        }
    }

    public void a(String str, Object obj) {
        d("  %s:\t%s\n", str, obj);
    }

    private boolean mf() {
        return h.a(this.Eb);
    }
}
