package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.i.b;
import com.facebook.internal.w;
import com.facebook.internal.x;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AccessTokenManager */
public final class c {
    private static volatile c wy;
    private final b wA;
    private a wB;
    private AtomicBoolean wC = new AtomicBoolean(false);
    private Date wD = new Date(0);
    private final LocalBroadcastManager wz;

    /* compiled from: AccessTokenManager */
    private static class a {
        public String wL;
        public int wM;
        public Long wN;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    c(LocalBroadcastManager localBroadcastManager, b bVar) {
        x.a((Object) localBroadcastManager, "localBroadcastManager");
        x.a((Object) bVar, "accessTokenCache");
        this.wz = localBroadcastManager;
        this.wA = bVar;
    }

    static c iD() {
        if (wy == null) {
            synchronized (c.class) {
                if (wy == null) {
                    wy = new c(LocalBroadcastManager.getInstance(h.getApplicationContext()), new b());
                }
            }
        }
        return wy;
    }

    a ik() {
        return this.wB;
    }

    boolean iE() {
        a iw = this.wA.iw();
        if (iw == null) {
            return false;
        }
        a(iw, false);
        return true;
    }

    void a(a aVar) {
        a(aVar, true);
    }

    private void a(a aVar, boolean z) {
        a aVar2 = this.wB;
        this.wB = aVar;
        this.wC.set(false);
        this.wD = new Date(0);
        if (z) {
            if (aVar != null) {
                this.wA.d(aVar);
            } else {
                this.wA.clear();
                w.ad(h.getApplicationContext());
            }
        }
        if (!w.d((Object) aVar2, (Object) aVar)) {
            a(aVar2, aVar);
            iG();
        }
    }

    void iF() {
        a(this.wB, this.wB);
    }

    private void a(a aVar, a aVar2) {
        Intent intent = new Intent(h.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", aVar);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", aVar2);
        this.wz.sendBroadcast(intent);
    }

    private void iG() {
        Context applicationContext = h.getApplicationContext();
        a ik = a.ik();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (a.il() && ik.in() != null && alarmManager != null) {
            Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
            alarmManager.set(1, ik.in().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 0));
        }
    }

    void iH() {
        if (iI()) {
            a(null);
        }
    }

    private boolean iI() {
        boolean z = false;
        if (this.wB == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        if (this.wB.ir().canExtendToken() && valueOf.longValue() - this.wD.getTime() > 3600000 && valueOf.longValue() - this.wB.is().getTime() > 86400000) {
            z = true;
        }
        return z;
    }

    private static i a(a aVar, b bVar) {
        return new i(aVar, "me/permissions", new Bundle(), HttpMethod.GET, bVar);
    }

    private static i b(a aVar, b bVar) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new i(aVar, "oauth/access_token", bundle, HttpMethod.GET, bVar);
    }

    void a(final com.facebook.a.a aVar) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            b(aVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    c.this.b(aVar);
                }
            });
        }
    }

    private void b(com.facebook.a.a aVar) {
        final a aVar2 = this.wB;
        if (aVar2 == null) {
            if (aVar != null) {
                aVar.a(new FacebookException("No current access token to refresh"));
            }
        } else if (this.wC.compareAndSet(false, true)) {
            this.wD = new Date();
            final Set hashSet = new HashSet();
            final Set hashSet2 = new HashSet();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final a aVar3 = new a();
            k kVar = new k(a(aVar2, new b() {
                public void a(l lVar) {
                    JSONObject jK = lVar.jK();
                    if (jK != null) {
                        JSONArray optJSONArray = jK.optJSONArray("data");
                        if (optJSONArray != null) {
                            atomicBoolean.set(true);
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                if (optJSONObject != null) {
                                    String optString = optJSONObject.optString("permission");
                                    String optString2 = optJSONObject.optString(NotificationCompat.CATEGORY_STATUS);
                                    if (!(w.bc(optString) || w.bc(optString2))) {
                                        optString2 = optString2.toLowerCase(Locale.US);
                                        if (optString2.equals("granted")) {
                                            hashSet.add(optString);
                                        } else if (optString2.equals("declined")) {
                                            hashSet2.add(optString);
                                        } else {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unexpected status: ");
                                            stringBuilder.append(optString2);
                                            Log.w("AccessTokenManager", stringBuilder.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }), b(aVar2, new b() {
                public void a(l lVar) {
                    JSONObject jK = lVar.jK();
                    if (jK != null) {
                        aVar3.wL = jK.optString("access_token");
                        aVar3.wM = jK.optInt("expires_at");
                        aVar3.wN = Long.valueOf(jK.optLong("data_access_expiration_time"));
                    }
                }
            }));
            final com.facebook.a.a aVar4 = aVar;
            kVar.a(new com.facebook.k.a() {
                public void a(k kVar) {
                    Throwable th;
                    a aVar;
                    try {
                        com.facebook.a.a aVar2;
                        if (c.iD().ik() == null || c.iD().ik().getUserId() != aVar2.getUserId()) {
                            if (aVar4 != null) {
                                aVar4.a(new FacebookException("No current access token to refresh"));
                            }
                            c.this.wC.set(false);
                            aVar2 = aVar4;
                        } else if (!atomicBoolean.get() && aVar3.wL == null && aVar3.wM == 0) {
                            if (aVar4 != null) {
                                aVar4.a(new FacebookException("Failed to refresh access token"));
                            }
                            c.this.wC.set(false);
                            aVar2 = aVar4;
                        } else {
                            String str;
                            Set set;
                            Date date;
                            Date date2;
                            if (aVar3.wL != null) {
                                str = aVar3.wL;
                            } else {
                                str = aVar2.getToken();
                            }
                            String str2 = str;
                            String it = aVar2.it();
                            String userId = aVar2.getUserId();
                            if (atomicBoolean.get()) {
                                set = hashSet;
                            } else {
                                set = aVar2.ip();
                            }
                            Set set2 = set;
                            if (atomicBoolean.get()) {
                                set = hashSet2;
                            } else {
                                set = aVar2.iq();
                            }
                            Set set3 = set;
                            AccessTokenSource ir = aVar2.ir();
                            if (aVar3.wM != 0) {
                                date = new Date(((long) aVar3.wM) * 1000);
                            } else {
                                date = aVar2.in();
                            }
                            Date date3 = new Date();
                            if (aVar3.wN != null) {
                                date2 = new Date(1000 * aVar3.wN.longValue());
                            } else {
                                date2 = aVar2.io();
                            }
                            a aVar3 = new a(str2, it, userId, set2, set3, ir, date, date3, date2);
                            try {
                                c.iD().a(aVar3);
                                c.this.wC.set(false);
                                if (!(aVar4 == null || aVar3 == null)) {
                                    aVar4.c(aVar3);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                aVar = aVar3;
                                c.this.wC.set(false);
                                aVar4.c(aVar);
                                throw th;
                            }
                        }
                    } catch (Throwable th22) {
                        th = th22;
                        aVar = null;
                        c.this.wC.set(false);
                        if (!(aVar4 == null || aVar == null)) {
                            aVar4.c(aVar);
                        }
                        throw th;
                    }
                }
            });
            kVar.jr();
        } else {
            if (aVar != null) {
                aVar.a(new FacebookException("Refresh already in progress"));
            }
        }
    }
}
