package com.iqoption.microservice.a;

import android.support.annotation.UiThread;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.b;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.util.ag;
import java.util.concurrent.TimeUnit;

/* compiled from: KycBusRequests */
public final class a {
    private static b<Long, com.iqoption.microservice.a.b.a> cQX = CacheBuilder.qh().A(1).a(10, TimeUnit.SECONDS).qw();
    private static b<Long, com.iqoption.microservice.a.b.a> cQY = CacheBuilder.qh().A(1).a(10, TimeUnit.MINUTES).qw();

    public static void asa() {
        com.iqoption.core.d.a.aSe.execute(new Runnable() {
            public void run() {
                a.cQX.invalidateAll();
                a.cQY.invalidateAll();
            }
        });
    }

    @UiThread
    public static s<com.iqoption.microservice.a.b.a> eb(boolean z) {
        b bVar;
        if (z) {
            bVar = cQY;
        } else {
            bVar = cQX;
        }
        Long valueOf = Long.valueOf(com.iqoption.app.a.Cw().getUserId());
        com.iqoption.microservice.a.b.a aVar = (com.iqoption.microservice.a.b.a) bVar.I(valueOf);
        if (aVar != null) {
            return o.aR(aVar);
        }
        return v(valueOf);
    }

    private static s<com.iqoption.microservice.a.b.a> v(final Long l) {
        s<com.iqoption.microservice.a.b.a> Sa = com.iqoption.mobbtech.connect.request.a.a.b.A(com.iqoption.microservice.a.b.a.class).ga("get-kyc-documents-status").cd(false).gb("2.0").Sa();
        ag.b(Sa, new n<com.iqoption.microservice.a.b.a>() {
            public void l(Throwable th) {
            }

            /* renamed from: b */
            public void onSuccess(com.iqoption.microservice.a.b.a aVar) {
                a.cQX.put(l, aVar);
                a.cQY.put(l, aVar);
            }
        });
        return Sa;
    }
}
