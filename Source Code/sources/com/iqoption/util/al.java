package com.iqoption.util;

import android.os.Handler;
import android.os.Looper;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: HandlerScheduler */
public class al {
    private final Map<Runnable, Runnable> dvR = Maps.us();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public void a(final Runnable runnable, final long j, long j2) {
        Runnable anonymousClass1 = new Runnable() {
            public void run() {
                runnable.run();
                al.this.handler.postDelayed(this, j);
            }
        };
        this.dvR.put(runnable, anonymousClass1);
        this.handler.postDelayed(anonymousClass1, j2);
    }

    public void b(Runnable runnable, long j) {
        a(runnable, j, 0);
    }

    public void m(Runnable runnable) {
        Runnable runnable2 = (Runnable) this.dvR.get(runnable);
        if (runnable2 != null) {
            this.dvR.remove(runnable2);
            this.handler.removeCallbacks((Runnable) this.dvR.get(runnable));
        }
    }

    public void clear() {
        this.handler.removeCallbacks(null);
    }
}
