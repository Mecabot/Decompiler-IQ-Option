package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.b.d;
import io.fabric.sdk.android.services.network.c;
import io.fabric.sdk.android.services.settings.b;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: AnswersEventsHandler */
class e implements d {
    private final Context context;
    final ScheduledExecutorService executor;
    private final h rR;
    private final f rS;
    private final ad rT;
    private final c rU;
    private final p rV;
    aa rW = new l();

    public e(h hVar, Context context, f fVar, ad adVar, c cVar, ScheduledExecutorService scheduledExecutorService, p pVar) {
        this.rR = hVar;
        this.context = context;
        this.rS = fVar;
        this.rT = adVar;
        this.rU = cVar;
        this.executor = scheduledExecutorService;
        this.rV = pVar;
    }

    public void a(a aVar) {
        a(aVar, false, false);
    }

    public void b(a aVar) {
        a(aVar, false, true);
    }

    public void c(a aVar) {
        a(aVar, true, false);
    }

    public void a(final b bVar, final String str) {
        g(new Runnable() {
            public void run() {
                try {
                    e.this.rW.a(bVar, str);
                } catch (Throwable e) {
                    io.fabric.sdk.android.c.aUg().e("Answers", "Failed to set analytics settings data", e);
                }
            }
        });
    }

    public void disable() {
        g(new Runnable() {
            public void run() {
                try {
                    aa aaVar = e.this.rW;
                    e.this.rW = new l();
                    aaVar.gA();
                } catch (Throwable e) {
                    io.fabric.sdk.android.c.aUg().e("Answers", "Failed to disable events", e);
                }
            }
        });
    }

    public void aJ(String str) {
        g(new Runnable() {
            public void run() {
                try {
                    e.this.rW.gz();
                } catch (Throwable e) {
                    io.fabric.sdk.android.c.aUg().e("Answers", "Failed to send events files", e);
                }
            }
        });
    }

    public void enable() {
        g(new Runnable() {
            public void run() {
                try {
                    ab gM = e.this.rT.gM();
                    x gs = e.this.rS.gs();
                    gs.a(e.this);
                    e.this.rW = new m(e.this.rR, e.this.context, e.this.executor, gs, e.this.rU, gM, e.this.rV);
                } catch (Throwable e) {
                    io.fabric.sdk.android.c.aUg().e("Answers", "Failed to enable events", e);
                }
            }
        });
    }

    public void gr() {
        g(new Runnable() {
            public void run() {
                try {
                    e.this.rW.gB();
                } catch (Throwable e) {
                    io.fabric.sdk.android.c.aUg().e("Answers", "Failed to flush events", e);
                }
            }
        });
    }

    void a(final a aVar, boolean z, final boolean z2) {
        Runnable anonymousClass6 = new Runnable() {
            public void run() {
                try {
                    e.this.rW.d(aVar);
                    if (z2) {
                        e.this.rW.gB();
                    }
                } catch (Throwable e) {
                    io.fabric.sdk.android.c.aUg().e("Answers", "Failed to process event", e);
                }
            }
        };
        if (z) {
            f(anonymousClass6);
        } else {
            g(anonymousClass6);
        }
    }

    private void f(Runnable runnable) {
        try {
            this.executor.submit(runnable).get();
        } catch (Throwable e) {
            io.fabric.sdk.android.c.aUg().e("Answers", "Failed to run events task", e);
        }
    }

    private void g(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Throwable e) {
            io.fabric.sdk.android.c.aUg().e("Answers", "Failed to submit events task", e);
        }
    }
}
