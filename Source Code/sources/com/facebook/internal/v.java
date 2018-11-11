package com.facebook.internal;

import com.facebook.h;
import java.util.Collection;

/* compiled from: ServerProtocol */
public final class v {
    public static final Collection<String> Es = w.a("service_disabled", "AndroidAuthKillSwitchException");
    public static final Collection<String> Et = w.a("access_denied", "OAuthAccessDeniedException");
    private static final String TAG = "com.facebook.internal.v";

    public static final String mt() {
        return "v3.2";
    }

    public static final String mq() {
        return String.format("m.%s", new Object[]{h.iY()});
    }

    public static final String mr() {
        return String.format("https://graph.%s", new Object[]{h.iY()});
    }

    public static final String ms() {
        return String.format("https://graph-video.%s", new Object[]{h.iY()});
    }
}
