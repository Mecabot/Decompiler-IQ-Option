package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* compiled from: NoLock */
class d implements Lock {
    public static final Lock eUq = new d();

    public void lock() {
    }

    public void unlock() {
    }

    private d() {
    }

    public void lockInterruptibly() {
        throw new UnsupportedOperationException("Should not be called");
    }

    public boolean tryLock() {
        throw new UnsupportedOperationException("Should not be called");
    }

    public boolean tryLock(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public Condition newCondition() {
        throw new UnsupportedOperationException("Should not be called");
    }
}
