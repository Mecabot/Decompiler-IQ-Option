package com.iqoption.util;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Debouncer */
public class p {
    private final Runnable duY;
    private final Handler handler;

    public p(Runnable runnable) {
        this(new Handler(Looper.getMainLooper()), runnable);
    }

    public p(Handler handler, Runnable runnable) {
        this.handler = handler;
        this.duY = runnable;
    }

    public void cg(long j) {
        this.handler.removeCallbacks(this.duY);
        this.handler.postDelayed(this.duY, j);
    }
}
