package io.fabric.sdk.android.services.common;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: TimingMetric */
public class r {
    private final boolean disabled;
    private long duration;
    private long enw;
    private final String sD;
    private final String tag;

    public r(String str, String str2) {
        this.sD = str;
        this.tag = str2;
        this.disabled = Log.isLoggable(str2, 2) ^ 1;
    }

    public synchronized void aUR() {
        if (!this.disabled) {
            this.enw = SystemClock.elapsedRealtime();
            this.duration = 0;
        }
    }

    public synchronized void aUS() {
        if (!this.disabled) {
            if (this.duration == 0) {
                this.duration = SystemClock.elapsedRealtime() - this.enw;
                aUT();
            }
        }
    }

    private void aUT() {
        String str = this.tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.sD);
        stringBuilder.append(": ");
        stringBuilder.append(this.duration);
        stringBuilder.append("ms");
        Log.v(str, stringBuilder.toString());
    }
}
