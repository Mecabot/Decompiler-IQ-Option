package io.reactivex.internal.util;

import io.reactivex.d.a;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BackpressureHelper */
public final class b {
    public static long y(long j, long j2) {
        long j3 = j + j2;
        return j3 < 0 ? Long.MAX_VALUE : j3;
    }

    public static long a(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, y(j2, j)));
        return j2;
    }

    public static long b(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, y(j2, j)));
        return j2;
    }

    public static long c(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j2 = j3 - j;
            if (j2 < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("More produced than requested: ");
                stringBuilder.append(j2);
                a.onError(new IllegalStateException(stringBuilder.toString()));
                j2 = 0;
            }
        } while (!atomicLong.compareAndSet(j3, j2));
        return j2;
    }

    public static long d(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j2 = j3 - j;
            if (j2 < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("More produced than requested: ");
                stringBuilder.append(j2);
                a.onError(new IllegalStateException(stringBuilder.toString()));
                j2 = 0;
            }
        } while (!atomicLong.compareAndSet(j3, j2));
        return j2;
    }
}
