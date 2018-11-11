package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;

abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable WO = new a();
    private static final Runnable WP = new a();

    private static final class a implements Runnable {
        public void run() {
        }

        private a() {
        }
    }

    abstract void b(T t, Throwable th);

    abstract boolean isDone();

    abstract T vU();

    InterruptibleTask() {
    }

    public final void run() {
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            Object vU;
            int isDone = isDone() ^ 1;
            if (isDone != 0) {
                try {
                    vU = vU();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, WO)) {
                        while (get() == WP) {
                            Thread.yield();
                        }
                    }
                    if (isDone != 0) {
                        b(null, null);
                    }
                }
            } else {
                vU = null;
            }
            if (!compareAndSet(currentThread, WO)) {
                while (get() == WP) {
                    Thread.yield();
                }
            }
            if (isDone != 0) {
                b(vU, null);
            }
        }
    }

    final void vD() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, WP)) {
            ((Thread) runnable).interrupt();
            set(WO);
        }
    }
}
