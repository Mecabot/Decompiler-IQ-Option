package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.k.a;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.c.b;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.l;
import io.fabric.sdk.android.services.network.c;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: SessionAnalyticsManager */
class z implements a {
    private final long sP;
    final e sQ;
    final io.fabric.sdk.android.a sR;
    final h sS;
    final k se;

    public void onError(String str) {
    }

    public static z a(h hVar, Context context, IdManager idManager, String str, String str2, long j) {
        Context context2 = context;
        ad adVar = new ad(context2, idManager, str, str2);
        h hVar2 = hVar;
        f fVar = new f(context2, new b(hVar2));
        c bVar = new io.fabric.sdk.android.services.network.b(io.fabric.sdk.android.c.aUg());
        io.fabric.sdk.android.a aVar = new io.fabric.sdk.android.a(context2);
        ScheduledExecutorService lB = l.lB("Answers Events Handler");
        k kVar = new k(lB);
        return new z(new e(hVar2, context2, fVar, adVar, bVar, lB, new p(context2)), aVar, kVar, h.K(context2), j);
    }

    z(e eVar, io.fabric.sdk.android.a aVar, k kVar, h hVar, long j) {
        this.sQ = eVar;
        this.sR = aVar;
        this.se = kVar;
        this.sS = hVar;
        this.sP = j;
    }

    public void enable() {
        this.sQ.enable();
        this.sR.a(new g(this, this.se));
        this.se.a((a) this);
        if (gL()) {
            j(this.sP);
            this.sS.gt();
        }
    }

    public void disable() {
        this.sR.aUd();
        this.sQ.disable();
    }

    public void k(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        io.fabric.sdk.android.c.aUg().d("Answers", "Logged crash");
        this.sQ.c(SessionEvent.l(str, str2));
    }

    public void j(long j) {
        io.fabric.sdk.android.c.aUg().d("Answers", "Logged install");
        this.sQ.b(SessionEvent.k(j));
    }

    public void a(Activity activity, Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Logged lifecycle event: ");
        stringBuilder.append(type.name());
        io.fabric.sdk.android.c.aUg().d("Answers", stringBuilder.toString());
        this.sQ.a(SessionEvent.a(type, activity));
    }

    public void gy() {
        io.fabric.sdk.android.c.aUg().d("Answers", "Flush events when app is backgrounded");
        this.sQ.gr();
    }

    public void a(io.fabric.sdk.android.services.settings.b bVar, String str) {
        this.se.C(bVar.sl);
        this.sQ.a(bVar, str);
    }

    boolean gL() {
        return this.sS.gu() ^ 1;
    }
}
