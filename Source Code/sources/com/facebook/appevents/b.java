package com.facebook.appevents;

import android.content.Context;
import com.facebook.h;
import java.util.HashMap;
import java.util.Set;

/* compiled from: AppEventCollection */
class b {
    private final HashMap<AccessTokenAppIdPair, f> yY = new HashMap();

    public synchronized void a(PersistedEvents persistedEvents) {
        if (persistedEvents != null) {
            for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
                f b = b(accessTokenAppIdPair);
                for (AppEvent a : persistedEvents.c(accessTokenAppIdPair)) {
                    b.a(a);
                }
            }
        }
    }

    public synchronized void a(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        b(accessTokenAppIdPair).a(appEvent);
    }

    public synchronized Set<AccessTokenAppIdPair> keySet() {
        return this.yY.keySet();
    }

    public synchronized f a(AccessTokenAppIdPair accessTokenAppIdPair) {
        return (f) this.yY.get(accessTokenAppIdPair);
    }

    public synchronized int kc() {
        int i;
        i = 0;
        for (f kq : this.yY.values()) {
            i += kq.kq();
        }
        return i;
    }

    private synchronized f b(AccessTokenAppIdPair accessTokenAppIdPair) {
        f fVar;
        fVar = (f) this.yY.get(accessTokenAppIdPair);
        if (fVar == null) {
            Context applicationContext = h.getApplicationContext();
            fVar = new f(com.facebook.internal.b.Y(applicationContext), AppEventsLogger.U(applicationContext));
        }
        this.yY.put(accessTokenAppIdPair, fVar);
        return fVar;
    }
}
