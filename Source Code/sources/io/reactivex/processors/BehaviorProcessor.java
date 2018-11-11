package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a.a;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.a.c;
import org.a.d;

public final class BehaviorProcessor<T> extends a<T> {
    static final Object[] QJ = new Object[0];
    static final BehaviorSubscription[] etu = new BehaviorSubscription[0];
    static final BehaviorSubscription[] etv = new BehaviorSubscription[0];
    final AtomicReference<Throwable> etA;
    final ReadWriteLock etw;
    final Lock etx;
    final Lock ety;
    final AtomicReference<Object> etz;
    long index;
    final AtomicReference<BehaviorSubscription<T>[]> subscribers;

    static final class BehaviorSubscription<T> extends AtomicLong implements a<Object>, d {
        private static final long serialVersionUID = 3293175281126227086L;
        final c<? super T> actual;
        volatile boolean cancelled;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        io.reactivex.internal.util.a<Object> queue;
        final BehaviorProcessor<T> state;

        BehaviorSubscription(c<? super T> cVar, BehaviorProcessor<T> behaviorProcessor) {
            this.actual = cVar;
            this.state = behaviorProcessor;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this, j);
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.b(this);
            }
        }

        /* JADX WARNING: Missing block: B:19:0x0031, code:
            if (r0 == null) goto L_0x003d;
     */
        /* JADX WARNING: Missing block: B:21:0x0037, code:
            if (test(r0) == false) goto L_0x003a;
     */
        /* JADX WARNING: Missing block: B:22:0x0039, code:
            return;
     */
        /* JADX WARNING: Missing block: B:23:0x003a, code:
            aXo();
     */
        /* JADX WARNING: Missing block: B:24:0x003d, code:
            return;
     */
        void aXn() {
            /*
            r4 = this;
            r0 = r4.cancelled;
            if (r0 == 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            monitor-enter(r4);
            r0 = r4.cancelled;	 Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000c;
        L_0x000a:
            monitor-exit(r4);	 Catch:{ all -> 0x003e }
            return;
        L_0x000c:
            r0 = r4.next;	 Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0012;
        L_0x0010:
            monitor-exit(r4);	 Catch:{ all -> 0x003e }
            return;
        L_0x0012:
            r0 = r4.state;	 Catch:{ all -> 0x003e }
            r1 = r0.etx;	 Catch:{ all -> 0x003e }
            r1.lock();	 Catch:{ all -> 0x003e }
            r2 = r0.index;	 Catch:{ all -> 0x003e }
            r4.index = r2;	 Catch:{ all -> 0x003e }
            r0 = r0.etz;	 Catch:{ all -> 0x003e }
            r0 = r0.get();	 Catch:{ all -> 0x003e }
            r1.unlock();	 Catch:{ all -> 0x003e }
            r1 = 1;
            if (r0 == 0) goto L_0x002b;
        L_0x0029:
            r2 = 1;
            goto L_0x002c;
        L_0x002b:
            r2 = 0;
        L_0x002c:
            r4.emitting = r2;	 Catch:{ all -> 0x003e }
            r4.next = r1;	 Catch:{ all -> 0x003e }
            monitor-exit(r4);	 Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d;
        L_0x0033:
            r0 = r4.test(r0);
            if (r0 == 0) goto L_0x003a;
        L_0x0039:
            return;
        L_0x003a:
            r4.aXo();
        L_0x003d:
            return;
        L_0x003e:
            r0 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x003e }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.BehaviorProcessor.BehaviorSubscription.aXn():void");
        }

        /* JADX WARNING: Missing block: B:25:0x0031, code:
            r3.fastPath = true;
     */
        void a(java.lang.Object r4, long r5) {
            /*
            r3 = this;
            r0 = r3.cancelled;
            if (r0 == 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            r0 = r3.fastPath;
            if (r0 != 0) goto L_0x0037;
        L_0x0009:
            monitor-enter(r3);
            r0 = r3.cancelled;	 Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0010;
        L_0x000e:
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            return;
        L_0x0010:
            r0 = r3.index;	 Catch:{ all -> 0x0034 }
            r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
            if (r2 != 0) goto L_0x0018;
        L_0x0016:
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            return;
        L_0x0018:
            r5 = r3.emitting;	 Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x002d;
        L_0x001c:
            r5 = r3.queue;	 Catch:{ all -> 0x0034 }
            if (r5 != 0) goto L_0x0028;
        L_0x0020:
            r5 = new io.reactivex.internal.util.a;	 Catch:{ all -> 0x0034 }
            r6 = 4;
            r5.<init>(r6);	 Catch:{ all -> 0x0034 }
            r3.queue = r5;	 Catch:{ all -> 0x0034 }
        L_0x0028:
            r5.add(r4);	 Catch:{ all -> 0x0034 }
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            return;
        L_0x002d:
            r5 = 1;
            r3.next = r5;	 Catch:{ all -> 0x0034 }
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            r3.fastPath = r5;
            goto L_0x0037;
        L_0x0034:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            throw r4;
        L_0x0037:
            r3.test(r4);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.BehaviorProcessor.BehaviorSubscription.a(java.lang.Object, long):void");
        }

        public boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.actual.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.actual.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j = get();
                if (j != 0) {
                    this.actual.e(NotificationLite.getValue(obj));
                    if (j != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                    return false;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }

        /* JADX WARNING: Missing block: B:12:0x0013, code:
            r0.a(r2);
     */
        void aXo() {
            /*
            r2 = this;
        L_0x0000:
            r0 = r2.cancelled;
            if (r0 == 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            monitor-enter(r2);
            r0 = r2.queue;	 Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x000f;
        L_0x000a:
            r0 = 0;
            r2.emitting = r0;	 Catch:{ all -> 0x0017 }
            monitor-exit(r2);	 Catch:{ all -> 0x0017 }
            return;
        L_0x000f:
            r1 = 0;
            r2.queue = r1;	 Catch:{ all -> 0x0017 }
            monitor-exit(r2);	 Catch:{ all -> 0x0017 }
            r0.a(r2);
            goto L_0x0000;
        L_0x0017:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0017 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.BehaviorProcessor.BehaviorSubscription.aXo():void");
        }
    }

    public static <T> BehaviorProcessor<T> aXm() {
        return new BehaviorProcessor();
    }

    public static <T> BehaviorProcessor<T> cl(T t) {
        io.reactivex.internal.a.b.requireNonNull(t, "defaultValue is null");
        return new BehaviorProcessor(t);
    }

    BehaviorProcessor() {
        this.etz = new AtomicReference();
        this.etw = new ReentrantReadWriteLock();
        this.etx = this.etw.readLock();
        this.ety = this.etw.writeLock();
        this.subscribers = new AtomicReference(etu);
        this.etA = new AtomicReference();
    }

    BehaviorProcessor(T t) {
        this();
        this.etz.lazySet(io.reactivex.internal.a.b.requireNonNull(t, "defaultValue is null"));
    }

    protected void a(c<? super T> cVar) {
        BehaviorSubscription behaviorSubscription = new BehaviorSubscription(cVar, this);
        cVar.a(behaviorSubscription);
        if (!a(behaviorSubscription)) {
            Throwable th = (Throwable) this.etA.get();
            if (th == ExceptionHelper.esW) {
                cVar.onComplete();
            } else {
                cVar.onError(th);
            }
        } else if (behaviorSubscription.cancelled) {
            b(behaviorSubscription);
        } else {
            behaviorSubscription.aXn();
        }
    }

    public void a(d dVar) {
        if (this.etA.get() != null) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void e(T t) {
        io.reactivex.internal.a.b.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.etA.get() == null) {
            Object next = NotificationLite.next(t);
            cn(next);
            for (BehaviorSubscription a : (BehaviorSubscription[]) this.subscribers.get()) {
                a.a(next, this.index);
            }
        }
    }

    public void onError(Throwable th) {
        io.reactivex.internal.a.b.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.etA.compareAndSet(null, th)) {
            Object error = NotificationLite.error(th);
            for (BehaviorSubscription a : cm(error)) {
                a.a(error, this.index);
            }
            return;
        }
        io.reactivex.d.a.onError(th);
    }

    public void onComplete() {
        if (this.etA.compareAndSet(null, ExceptionHelper.esW)) {
            Object complete = NotificationLite.complete();
            for (BehaviorSubscription a : cm(complete)) {
                a.a(complete, this.index);
            }
        }
    }

    public T getValue() {
        Object obj = this.etz.get();
        return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj);
    }

    boolean a(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        Object obj;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
            if (behaviorSubscriptionArr == etv) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            obj = new BehaviorSubscription[(length + 1)];
            System.arraycopy(behaviorSubscriptionArr, 0, obj, 0, length);
            obj[length] = behaviorSubscription;
        } while (!this.subscribers.compareAndSet(behaviorSubscriptionArr, obj));
        return true;
    }

    void b(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        Object obj;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
            int length = behaviorSubscriptionArr.length;
            if (length != 0) {
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (behaviorSubscriptionArr[i2] == behaviorSubscription) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = etu;
                    } else {
                        Object obj2 = new BehaviorSubscription[(length - 1)];
                        System.arraycopy(behaviorSubscriptionArr, 0, obj2, 0, i);
                        System.arraycopy(behaviorSubscriptionArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            }
            return;
        } while (!this.subscribers.compareAndSet(behaviorSubscriptionArr, obj));
    }

    BehaviorSubscription<T>[] cm(Object obj) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
        if (behaviorSubscriptionArr != etv) {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.getAndSet(etv);
            if (behaviorSubscriptionArr != etv) {
                cn(obj);
            }
        }
        return behaviorSubscriptionArr;
    }

    void cn(Object obj) {
        Lock lock = this.ety;
        lock.lock();
        this.index++;
        this.etz.lazySet(obj);
        lock.unlock();
    }
}
