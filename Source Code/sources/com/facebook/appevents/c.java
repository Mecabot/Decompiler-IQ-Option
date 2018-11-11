package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.FacebookRequestError;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.h;
import com.facebook.i;
import com.facebook.i.b;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: AppEventQueue */
class c {
    private static final String TAG = "com.facebook.appevents.c";
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    private static volatile b yZ = new b();
    private static ScheduledFuture za;
    private static final Runnable zb = new Runnable() {
        public void run() {
            c.za = null;
            if (AppEventsLogger.kj() != FlushBehavior.EXPLICIT_ONLY) {
                c.b(FlushReason.TIMER);
            }
        }
    };

    c() {
    }

    public static void kd() {
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                d.b(c.yZ);
                c.yZ = new b();
            }
        });
    }

    public static void a(final FlushReason flushReason) {
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                c.b(flushReason);
            }
        });
    }

    public static void b(final AccessTokenAppIdPair accessTokenAppIdPair, final AppEvent appEvent) {
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                c.yZ.a(accessTokenAppIdPair, appEvent);
                if (AppEventsLogger.kj() != FlushBehavior.EXPLICIT_ONLY && c.yZ.kc() > 100) {
                    c.b(FlushReason.EVENT_THRESHOLD);
                } else if (c.za == null) {
                    c.za = c.singleThreadExecutor.schedule(c.zb, 15, TimeUnit.SECONDS);
                }
            }
        });
    }

    public static Set<AccessTokenAppIdPair> getKeySet() {
        return yZ.keySet();
    }

    static void b(FlushReason flushReason) {
        yZ.a(d.ki());
        try {
            e a = a(flushReason, yZ);
            if (a != null) {
                Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", a.zr);
                intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", a.zs);
                LocalBroadcastManager.getInstance(h.getApplicationContext()).sendBroadcast(intent);
            }
        } catch (Throwable e) {
            Log.w(TAG, "Caught unexpected exception while flushing app events: ", e);
        }
    }

    private static e a(FlushReason flushReason, b bVar) {
        e eVar = new e();
        boolean R = h.R(h.getApplicationContext());
        List<i> arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : bVar.keySet()) {
            i a = a(accessTokenAppIdPair, bVar.a(accessTokenAppIdPair), R, eVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        q.a(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(eVar.zr), flushReason.toString());
        for (i jq : arrayList) {
            jq.jq();
        }
        return eVar;
    }

    private static i a(final AccessTokenAppIdPair accessTokenAppIdPair, final f fVar, boolean z, final e eVar) {
        boolean z2 = false;
        l f = FetchedAppSettingsManager.f(accessTokenAppIdPair.it(), false);
        final i a = i.a(null, String.format("%s/activities", new Object[]{r0}), null, null);
        Bundle jn = a.jn();
        if (jn == null) {
            jn = new Bundle();
        }
        jn.putString("access_token", accessTokenAppIdPair.jV());
        String kl = AppEventsLogger.kl();
        if (kl != null) {
            jn.putString("device_token", kl);
        }
        a.setParameters(jn);
        if (f != null) {
            z2 = f.lF();
        }
        int a2 = fVar.a(a, h.getApplicationContext(), z2, z);
        if (a2 == 0) {
            return null;
        }
        eVar.zr += a2;
        a.a(new b() {
            public void a(com.facebook.l lVar) {
                c.a(accessTokenAppIdPair, a, lVar, fVar, eVar);
            }
        });
        return a;
    }

    private static void a(final AccessTokenAppIdPair accessTokenAppIdPair, i iVar, com.facebook.l lVar, final f fVar, e eVar) {
        FacebookRequestError jJ = lVar.jJ();
        String str = "Success";
        FlushResult flushResult = FlushResult.SUCCESS;
        boolean z = true;
        if (jJ != null) {
            if (jJ.getErrorCode() == -1) {
                str = "Failed: No Connectivity";
                flushResult = FlushResult.NO_CONNECTIVITY;
            } else {
                str = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{lVar.toString(), jJ.toString()});
                flushResult = FlushResult.SERVER_ERROR;
            }
        }
        if (h.a(LoggingBehavior.APP_EVENTS)) {
            String jSONArray;
            try {
                jSONArray = new JSONArray((String) iVar.getTag()).toString(2);
            } catch (JSONException unused) {
                jSONArray = "<Can't encode events for debug logging>";
            }
            q.a(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", iVar.jk().toString(), str, jSONArray);
        }
        if (jJ == null) {
            z = false;
        }
        fVar.J(z);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            h.getExecutor().execute(new Runnable() {
                public void run() {
                    d.a(accessTokenAppIdPair, fVar);
                }
            });
        }
        if (flushResult != FlushResult.SUCCESS && eVar.zs != FlushResult.NO_CONNECTIVITY) {
            eVar.zs = flushResult;
        }
    }
}
