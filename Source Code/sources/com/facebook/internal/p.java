package com.facebook.internal;

import com.facebook.h;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/* compiled from: LockOnGetVariable */
public class p<T> {
    private CountDownLatch DX = new CountDownLatch(1);
    private T value;

    public p(final Callable<T> callable) {
        h.getExecutor().execute(new FutureTask(new Callable<Void>() {
            public Void call() {
                try {
                    p.this.value = callable.call();
                    return null;
                } finally {
                    p.this.DX.countDown();
                }
            }
        }));
    }

    public T getValue() {
        me();
        return this.value;
    }

    private void me() {
        if (this.DX != null) {
            try {
                this.DX.await();
            } catch (InterruptedException unused) {
            }
        }
    }
}
