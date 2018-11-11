package com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Uninterruptibles */
public final class ab {
    public static <V> V c(Future<V> future) {
        Object obj = null;
        while (true) {
            try {
                V v = future.get();
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
                return v;
            } catch (InterruptedException unused) {
                obj = 1;
            } catch (Throwable th) {
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void c(long j, TimeUnit timeUnit) {
        long nanoTime;
        Object obj = null;
        try {
            j = timeUnit.toNanos(j);
            nanoTime = System.nanoTime() + j;
            while (true) {
                TimeUnit.NANOSECONDS.sleep(j);
                if (obj != null) {
                    Thread.currentThread().interrupt();
                    return;
                }
                return;
            }
        } catch (InterruptedException unused) {
            obj = 1;
            j = nanoTime - System.nanoTime();
        } catch (Throwable th) {
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
