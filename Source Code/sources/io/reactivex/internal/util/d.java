package io.reactivex.internal.util;

import io.reactivex.d.a;
import java.util.concurrent.atomic.AtomicInteger;
import org.a.c;

/* compiled from: HalfSerializer */
public final class d {
    public static <T> void a(c<? super T> cVar, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.e(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable aXi = atomicThrowable.aXi();
                if (aXi != null) {
                    cVar.onError(aXi);
                } else {
                    cVar.onComplete();
                }
            }
        }
    }

    public static void a(c<?> cVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.Y(th)) {
            a.onError(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            cVar.onError(atomicThrowable.aXi());
        }
    }

    public static void a(c<?> cVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable aXi = atomicThrowable.aXi();
            if (aXi != null) {
                cVar.onError(aXi);
            } else {
                cVar.onComplete();
            }
        }
    }
}
