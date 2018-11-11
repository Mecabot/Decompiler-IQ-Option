package com.iqoption.app.managers;

import android.os.SystemClock;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.iqoption.app.managers.tab.a;
import com.iqoption.core.i;
import com.iqoption.gl.b;
import java.util.concurrent.TimeUnit;

/* compiled from: TimeServerManager */
public class af {
    private static final String TAG = "com.iqoption.app.managers.af";
    private static final n<af> anO = Suppliers.a(ag.ajD);
    private static final long anP = TimeUnit.MINUTES.toMillis(30);
    private volatile long anQ = 0;
    private volatile long anR = 0;
    private volatile long anS;
    private volatile long anT = 0;
    private volatile long anU = 0;

    private af() {
    }

    public static af Hu() {
        return (af) anO.get();
    }

    public void clear() {
        this.anT = 0;
        this.anU = 0;
        this.anQ = 0;
        this.anR = 0;
    }

    public void au(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime - this.anS;
        String str;
        StringBuilder stringBuilder;
        if (j > this.anR) {
            long j3 = j - this.anQ;
            if ((j3 < j2 ? 1 : null) == null || this.anQ == 0 || Math.abs(j3 - j2) >= anP) {
                this.anQ = j;
                this.anS = elapsedRealtime;
                b.aow().glchSetServerTime(((double) j) / 1000.0d);
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("update time sync ");
                stringBuilder.append(this.anQ);
                stringBuilder.append(", localElapsed=");
                stringBuilder.append(j2);
                stringBuilder.append(", serverElapsed=");
                stringBuilder.append(j3);
                i.v(str, stringBuilder.toString());
            } else {
                this.anQ += j2;
                this.anS = elapsedRealtime;
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("SKIP update time sync ");
                stringBuilder.append(j);
                stringBuilder.append(", localElapsed=");
                stringBuilder.append(j2);
                stringBuilder.append(", serverElapsed=");
                stringBuilder.append(j3);
                stringBuilder.append(" set timeSync=");
                stringBuilder.append(this.anQ);
                i.d(str, stringBuilder.toString());
                b.aow().glchSetServerTime(((double) this.anQ) / 1000.0d);
            }
        } else {
            this.anQ += j2;
            this.anS = elapsedRealtime;
            b.aow().glchSetServerTime(((double) this.anQ) / 1000.0d);
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("time sync error, prevTimeSync=");
            stringBuilder.append(this.anQ);
            stringBuilder.append(", newTimeSync=");
            stringBuilder.append(j);
            stringBuilder.append("set time sync to ");
            stringBuilder.append(this.anQ);
            i.e(str, stringBuilder.toString());
        }
        this.anR = j;
    }

    public long Hv() {
        return this.anR;
    }

    public long Hw() {
        if (this.anQ == 0) {
            return System.currentTimeMillis();
        }
        return this.anQ + (SystemClock.elapsedRealtime() - this.anS);
    }

    public void e(int i, long j) {
        if (a.Il().It() == i) {
            this.anT = SystemClock.elapsedRealtime();
            this.anU = j;
        }
    }

    public boolean Hx() {
        return this.anT != 0;
    }

    public boolean Hy() {
        return SystemClock.elapsedRealtime() - this.anT > 5000;
    }

    public boolean Hz() {
        return Hw() - this.anU < 3000;
    }
}
