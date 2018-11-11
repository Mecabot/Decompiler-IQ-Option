package com.iqoption.view.d;

import android.os.SystemClock;

/* compiled from: OnClickDelayNative */
public abstract class a<T> {
    private long doZ = 300;
    private long dpa;

    protected abstract void bu(T t);

    public void bP(T t) {
        if (SystemClock.elapsedRealtime() - this.dpa >= this.doZ) {
            this.dpa = SystemClock.elapsedRealtime();
            bu(t);
        }
    }
}
