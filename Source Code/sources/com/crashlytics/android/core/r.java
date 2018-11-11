package com.crashlytics.android.core;

import io.fabric.sdk.android.c;
import io.fabric.sdk.android.services.settings.s;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class r implements UncaughtExceptionHandler {
    private final a vd;
    private final b ve;
    private final boolean vf;
    private final UncaughtExceptionHandler vg;
    private final AtomicBoolean vh = new AtomicBoolean(false);

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    interface a {
        void b(b bVar, Thread thread, Throwable th, boolean z);
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    interface b {
        s hk();
    }

    public r(a aVar, b bVar, boolean z, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.vd = aVar;
        this.ve = bVar;
        this.vf = z;
        this.vg = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.vh.set(true);
        try {
            this.vd.b(this.ve, thread, th, this.vf);
        } catch (Throwable e) {
            c.aUg().e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
        } catch (Throwable th2) {
            c.aUg().d("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.vg.uncaughtException(thread, th);
            this.vh.set(false);
        }
        c.aUg().d("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
        this.vg.uncaughtException(thread, th);
        this.vh.set(false);
    }

    boolean hd() {
        return this.vh.get();
    }
}
