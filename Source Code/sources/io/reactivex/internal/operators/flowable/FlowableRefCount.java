package io.reactivex.internal.operators.flowable;

import io.reactivex.b.a;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.n;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public final class FlowableRefCount<T> extends e<T> {
    RefConnection connection;
    final a<T> erl;
    final int n;
    final n scheduler;
    final long timeout;
    final TimeUnit unit;

    static final class RefConnection extends AtomicReference<b> implements io.reactivex.c.e<b>, Runnable {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        final FlowableRefCount<?> parent;
        long subscriberCount;
        b timer;

        RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.parent = flowableRefCount;
        }

        public void run() {
            this.parent.c(this);
        }

        /* renamed from: j */
        public void accept(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    static final class RefCountSubscriber<T> extends AtomicBoolean implements h<T>, d {
        private static final long serialVersionUID = -7419642935409022375L;
        final c<? super T> actual;
        final RefConnection connection;
        final FlowableRefCount<T> parent;
        d upstream;

        RefCountSubscriber(c<? super T> cVar, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.actual = cVar;
            this.parent = flowableRefCount;
            this.connection = refConnection;
        }

        public void e(T t) {
            this.actual.e(t);
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
                this.actual.onError(th);
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
                this.actual.onComplete();
            }
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                this.parent.a(this.connection);
            }
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.actual.a(this);
            }
        }
    }

    public FlowableRefCount(a<T> aVar) {
        this(aVar, 1, 0, TimeUnit.NANOSECONDS, io.reactivex.e.a.aXu());
    }

    public FlowableRefCount(a<T> aVar, int i, long j, TimeUnit timeUnit, n nVar) {
        this.erl = aVar;
        this.n = i;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = nVar;
    }

    protected void a(c<? super T> cVar) {
        io.reactivex.c.e eVar;
        boolean z;
        synchronized (this) {
            eVar = this.connection;
            if (eVar == null) {
                eVar = new RefConnection(this);
                this.connection = eVar;
            }
            long j = eVar.subscriberCount;
            if (j == 0 && eVar.timer != null) {
                eVar.timer.dispose();
            }
            long j2 = j + 1;
            eVar.subscriberCount = j2;
            z = true;
            if (eVar.connected || j2 != ((long) this.n)) {
                z = false;
            } else {
                eVar.connected = true;
            }
        }
        this.erl.a(new RefCountSubscriber(cVar, this, eVar));
        if (z) {
            this.erl.e(eVar);
        }
    }

    void a(RefConnection refConnection) {
        synchronized (this) {
            if (this.connection == null) {
                return;
            }
            long j = refConnection.subscriberCount - 1;
            refConnection.subscriberCount = j;
            if (j != 0 || !refConnection.connected) {
            } else if (this.timeout == 0) {
                c(refConnection);
            } else {
                Object sequentialDisposable = new SequentialDisposable();
                refConnection.timer = sequentialDisposable;
                sequentialDisposable.h(this.scheduler.b(refConnection, this.timeout, this.unit));
            }
        }
    }

    void b(RefConnection refConnection) {
        synchronized (this) {
            if (this.connection != null) {
                this.connection = null;
                if (refConnection.timer != null) {
                    refConnection.timer.dispose();
                }
                if (this.erl instanceof b) {
                    ((b) this.erl).dispose();
                }
            }
        }
    }

    void c(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.connection) {
                this.connection = null;
                DisposableHelper.dispose(refConnection);
                if (this.erl instanceof b) {
                    ((b) this.erl).dispose();
                }
            }
        }
    }
}
