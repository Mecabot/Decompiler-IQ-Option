package com.crashlytics.android.answers;

import android.content.Context;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.k;
import io.fabric.sdk.android.services.b.f;
import io.fabric.sdk.android.services.b.i;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.g;
import io.fabric.sdk.android.services.network.c;
import io.fabric.sdk.android.services.settings.b;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EnabledSessionAnalyticsManagerStrategy */
class m implements aa {
    private final Context context;
    private final h rR;
    private final p rV;
    boolean sA = false;
    private final ScheduledExecutorService sk;
    private final c sp;
    private final x sq;
    private final AtomicReference<ScheduledFuture<?>> sr = new AtomicReference();
    final ab ss;
    f st;
    g su = new g();
    n sv = new s();
    boolean sw = true;
    boolean sx = true;
    volatile int sy = -1;
    boolean sz = false;

    public m(h hVar, Context context, ScheduledExecutorService scheduledExecutorService, x xVar, c cVar, ab abVar, p pVar) {
        this.rR = hVar;
        this.context = context;
        this.sk = scheduledExecutorService;
        this.sq = xVar;
        this.sp = cVar;
        this.ss = abVar;
        this.rV = pVar;
    }

    public void a(b bVar, String str) {
        this.st = i.a(new y(this.rR, str, bVar.eoO, this.sp, this.su.cA(this.context)));
        this.sq.a(bVar);
        this.sz = bVar.eoT;
        this.sA = bVar.sA;
        k aUg = io.fabric.sdk.android.c.aUg();
        String str2 = "Answers";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Firebase analytics forwarding ");
        stringBuilder.append(this.sz ? "enabled" : "disabled");
        aUg.d(str2, stringBuilder.toString());
        aUg = io.fabric.sdk.android.c.aUg();
        str2 = "Answers";
        stringBuilder = new StringBuilder();
        stringBuilder.append("Firebase analytics including purchase events ");
        stringBuilder.append(this.sA ? "enabled" : "disabled");
        aUg.d(str2, stringBuilder.toString());
        this.sw = bVar.eoU;
        aUg = io.fabric.sdk.android.c.aUg();
        str2 = "Answers";
        stringBuilder = new StringBuilder();
        stringBuilder.append("Custom event tracking ");
        stringBuilder.append(this.sw ? "enabled" : "disabled");
        aUg.d(str2, stringBuilder.toString());
        this.sx = bVar.eoV;
        aUg = io.fabric.sdk.android.c.aUg();
        str2 = "Answers";
        stringBuilder = new StringBuilder();
        stringBuilder.append("Predefined event tracking ");
        stringBuilder.append(this.sx ? "enabled" : "disabled");
        aUg.d(str2, stringBuilder.toString());
        if (bVar.sL > 1) {
            io.fabric.sdk.android.c.aUg().d("Answers", "Event sampling enabled");
            this.sv = new w(bVar.sL);
        }
        this.sy = bVar.eoP;
        b(0, (long) this.sy);
    }

    public void d(a aVar) {
        StringBuilder stringBuilder;
        SessionEvent a = aVar.a(this.ss);
        StringBuilder stringBuilder2;
        if (!this.sw && Type.CUSTOM.equals(a.sU)) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Custom events tracking disabled - skipping event: ");
            stringBuilder2.append(a);
            io.fabric.sdk.android.c.aUg().d("Answers", stringBuilder2.toString());
        } else if (!this.sx && Type.PREDEFINED.equals(a.sU)) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Predefined events tracking disabled - skipping event: ");
            stringBuilder2.append(a);
            io.fabric.sdk.android.c.aUg().d("Answers", stringBuilder2.toString());
        } else if (this.sv.a(a)) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Skipping filtered event: ");
            stringBuilder2.append(a);
            io.fabric.sdk.android.c.aUg().d("Answers", stringBuilder2.toString());
        } else {
            try {
                this.sq.bV(a);
            } catch (Throwable e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to write event: ");
                stringBuilder.append(a);
                io.fabric.sdk.android.c.aUg().e("Answers", stringBuilder.toString(), e);
            }
            gD();
            Object obj = (Type.CUSTOM.equals(a.sU) || Type.PREDEFINED.equals(a.sU)) ? 1 : null;
            boolean equals = ProductAction.ACTION_PURCHASE.equals(a.sY);
            if (this.sz && obj != null) {
                if (!equals || this.sA) {
                    try {
                        this.rV.b(a);
                    } catch (Throwable e2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to map event to Firebase: ");
                        stringBuilder.append(a);
                        io.fabric.sdk.android.c.aUg().e("Answers", stringBuilder.toString(), e2);
                    }
                }
            }
        }
    }

    public void gD() {
        if ((this.sy != -1 ? 1 : null) != null) {
            b((long) this.sy, (long) this.sy);
        }
    }

    public void gz() {
        if (this.st == null) {
            CommonUtils.H(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.H(this.context, "Sending all files");
        List aVh = this.sq.aVh();
        int i = 0;
        while (aVh.size() > 0) {
            try {
                CommonUtils.H(this.context, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(aVh.size())}));
                boolean q = this.st.q(aVh);
                if (q) {
                    i += aVh.size();
                    this.sq.bN(aVh);
                }
                if (!q) {
                    break;
                }
                aVh = this.sq.aVh();
            } catch (Throwable e) {
                Context context = this.context;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to send batch of analytics files to server: ");
                stringBuilder.append(e.getMessage());
                CommonUtils.a(context, stringBuilder.toString(), e);
            }
        }
        if (i == 0) {
            this.sq.aVj();
        }
    }

    public void gC() {
        if (this.sr.get() != null) {
            CommonUtils.H(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.sr.get()).cancel(false);
            this.sr.set(null);
        }
    }

    public void gA() {
        this.sq.aVi();
    }

    public boolean gB() {
        try {
            return this.sq.gB();
        } catch (Throwable e) {
            CommonUtils.a(this.context, "Failed to roll file over.", e);
            return false;
        }
    }

    void b(long j, long j2) {
        if ((this.sr.get() == null ? 1 : null) != null) {
            Runnable iVar = new i(this.context, this);
            Context context = this.context;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling time based file roll over every ");
            stringBuilder.append(j2);
            stringBuilder.append(" seconds");
            CommonUtils.H(context, stringBuilder.toString());
            try {
                this.sr.set(this.sk.scheduleAtFixedRate(iVar, j, j2, TimeUnit.SECONDS));
            } catch (Throwable e) {
                CommonUtils.a(this.context, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
