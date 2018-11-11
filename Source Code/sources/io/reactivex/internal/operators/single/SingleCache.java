package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCache<T> extends o<T> implements q<T> {
    static final CacheDisposable[] erv = new CacheDisposable[0];
    static final CacheDisposable[] erw = new CacheDisposable[0];
    Throwable error;
    final AtomicReference<CacheDisposable<T>[]> erx = new AtomicReference(erv);
    final s<? extends T> source;
    T value;
    final AtomicInteger wip = new AtomicInteger();

    static final class CacheDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 7514387411091976596L;
        final q<? super T> actual;
        final SingleCache<T> parent;

        CacheDisposable(q<? super T> qVar, SingleCache<T> singleCache) {
            this.actual = qVar;
            this.parent = singleCache;
        }

        public boolean isDisposed() {
            return get();
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.b(this);
            }
        }
    }

    public void d(b bVar) {
    }

    public SingleCache(s<? extends T> sVar) {
        this.source = sVar;
    }

    protected void b(q<? super T> qVar) {
        CacheDisposable cacheDisposable = new CacheDisposable(qVar, this);
        qVar.d(cacheDisposable);
        if (a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                b(cacheDisposable);
            }
            if (this.wip.getAndIncrement() == 0) {
                this.source.a(this);
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            qVar.onError(th);
        } else {
            qVar.onSuccess(this.value);
        }
    }

    boolean a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        Object obj;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.erx.get();
            if (cacheDisposableArr == erw) {
                return false;
            }
            int length = cacheDisposableArr.length;
            obj = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, obj, 0, length);
            obj[length] = cacheDisposable;
        } while (!this.erx.compareAndSet(cacheDisposableArr, obj));
        return true;
    }

    void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        Object obj;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.erx.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (cacheDisposableArr[i2] == cacheDisposable) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = erv;
                    } else {
                        Object obj2 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, obj2, 0, i);
                        System.arraycopy(cacheDisposableArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            }
            return;
        } while (!this.erx.compareAndSet(cacheDisposableArr, obj));
    }

    public void onSuccess(T t) {
        this.value = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.erx.getAndSet(erw)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onSuccess(t);
            }
        }
    }

    public void onError(Throwable th) {
        this.error = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.erx.getAndSet(erw)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onError(th);
            }
        }
    }
}
