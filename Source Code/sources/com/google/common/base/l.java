package com.google.common.base;

import java.util.concurrent.TimeUnit;

/* compiled from: Stopwatch */
public final class l {
    private boolean Fs;
    private long Nt;
    private long Nu;
    private final p ticker = p.qe();

    /* compiled from: Stopwatch */
    /* renamed from: com.google.common.base.l$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Nv = new int[TimeUnit.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:14:?, code:
            Nv[java.util.concurrent.TimeUnit.DAYS.ordinal()] = 7;
     */
        static {
            /*
            r0 = java.util.concurrent.TimeUnit.values();
            r0 = r0.length;
            r0 = new int[r0];
            Nv = r0;
            r0 = Nv;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = Nv;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = java.util.concurrent.TimeUnit.MICROSECONDS;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = Nv;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = Nv;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = Nv;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = java.util.concurrent.TimeUnit.MINUTES;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = Nv;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = java.util.concurrent.TimeUnit.HOURS;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r0 = Nv;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = java.util.concurrent.TimeUnit.DAYS;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.l.1.<clinit>():void");
        }
    }

    public static l pW() {
        return new l();
    }

    public static l pX() {
        return new l().pY();
    }

    l() {
    }

    public l pY() {
        i.a(this.Fs ^ true, "This stopwatch is already running.");
        this.Fs = true;
        this.Nu = this.ticker.qd();
        return this;
    }

    private long pZ() {
        return this.Fs ? (this.ticker.qd() - this.Nu) + this.Nt : this.Nt;
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(pZ(), TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long pZ = pZ();
        TimeUnit x = x(pZ);
        double convert = ((double) pZ) / ((double) TimeUnit.NANOSECONDS.convert(1, x));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(h.c(convert));
        stringBuilder.append(" ");
        stringBuilder.append(b(x));
        return stringBuilder.toString();
    }

    private static TimeUnit x(long j) {
        if (TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }

    private static String b(TimeUnit timeUnit) {
        switch (AnonymousClass1.Nv[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }
}
