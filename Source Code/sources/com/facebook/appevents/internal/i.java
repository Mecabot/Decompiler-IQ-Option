package com.facebook.appevents.internal;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.internal.q;
import java.util.Locale;

/* compiled from: SessionLogger */
class i {
    private static final long[] Br = new long[]{300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final String TAG = i.class.getCanonicalName();

    i() {
    }

    public static void a(String str, j jVar, String str2) {
        String jVar2 = jVar != null ? jVar.toString() : "Unclassified";
        Bundle bundle = new Bundle();
        bundle.putString("fb_mobile_launch_source", jVar2);
        AppEventsLogger gVar = new g(str, str2, null);
        gVar.logEvent("fb_mobile_activate_app", bundle);
        if (AppEventsLogger.kj() != FlushBehavior.EXPLICIT_ONLY) {
            gVar.flush();
        }
    }

    public static void a(String str, h hVar, String str2) {
        Long valueOf = Long.valueOf(hVar.ll() - hVar.li().longValue());
        if (valueOf.longValue() < 0) {
            valueOf = Long.valueOf(0);
            lp();
        }
        Long valueOf2 = Long.valueOf(hVar.lm());
        if (valueOf2.longValue() < 0) {
            lp();
            valueOf2 = Long.valueOf(0);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("fb_mobile_app_interruptions", hVar.lj());
        bundle.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", new Object[]{Integer.valueOf(u(valueOf.longValue()))}));
        j ln = hVar.ln();
        bundle.putString("fb_mobile_launch_source", ln != null ? ln.toString() : "Unclassified");
        bundle.putLong("_logTime", hVar.li().longValue() / 1000);
        new g(str, str2, null).a("fb_mobile_deactivate_app", (double) (valueOf2.longValue() / 1000), bundle);
    }

    private static void lp() {
        q.a(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    }

    private static int u(long j) {
        int i = 0;
        while (i < Br.length && Br[i] < j) {
            i++;
        }
        return i;
    }
}
