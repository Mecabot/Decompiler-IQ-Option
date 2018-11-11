package io.reactivex.subjects;

import io.reactivex.disposables.b;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BehaviorSubject */
public final class a<T> extends c<T> {
    private static final Object[] QJ = new Object[0];
    static final a[] etN = new a[0];
    static final a[] etO = new a[0];
    final AtomicReference<Throwable> etA = new AtomicReference();
    final ReadWriteLock etw = new ReentrantReadWriteLock();
    final Lock etx = this.etw.readLock();
    final Lock ety = this.etw.writeLock();
    final AtomicReference<Object> etz = new AtomicReference();
    long index;
    final AtomicReference<a<T>[]> subscribers = new AtomicReference(etN);

    /* compiled from: BehaviorSubject */
    static final class a<T> implements b, io.reactivex.internal.util.a.a<Object> {
        final m<? super T> actual;
        volatile boolean cancelled;
        boolean emitting;
        final a<T> etP;
        boolean fastPath;
        long index;
        boolean next;
        io.reactivex.internal.util.a<Object> queue;

        a(m<? super T> mVar, a<T> aVar) {
            this.actual = mVar;
            this.etP = aVar;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.etP.b(this);
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
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
            r0 = r4.etP;	 Catch:{ all -> 0x003e }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.a.a.aXn():void");
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.a.a.a(java.lang.Object, long):void");
        }

        public boolean test(Object obj) {
            return this.cancelled || NotificationLite.accept(obj, this.actual);
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.a.a.aXo():void");
        }
    }

    public static <T> a<T> aXw() {
        return new a();
    }

    a() {
    }

    protected void b(m<? super T> mVar) {
        a aVar = new a(mVar, this);
        mVar.d(aVar);
        if (!a(aVar)) {
            Throwable th = (Throwable) this.etA.get();
            if (th == ExceptionHelper.esW) {
                mVar.onComplete();
            } else {
                mVar.onError(th);
            }
        } else if (aVar.cancelled) {
            b(aVar);
        } else {
            aVar.aXn();
        }
    }

    public void d(b bVar) {
        if (this.etA.get() != null) {
            bVar.dispose();
        }
    }

    public void e(T t) {
        io.reactivex.internal.a.b.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.etA.get() == null) {
            Object next = NotificationLite.next(t);
            cn(next);
            for (a a : (a[]) this.subscribers.get()) {
                a.a(next, this.index);
            }
        }
    }

    public void onError(Throwable th) {
        io.reactivex.internal.a.b.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.etA.compareAndSet(null, th)) {
            Object error = NotificationLite.error(th);
            for (a a : co(error)) {
                a.a(error, this.index);
            }
            return;
        }
        io.reactivex.d.a.onError(th);
    }

    public void onComplete() {
        if (this.etA.compareAndSet(null, ExceptionHelper.esW)) {
            Object complete = NotificationLite.complete();
            for (a a : co(complete)) {
                a.a(complete, this.index);
            }
        }
    }

    public boolean aXx() {
        return NotificationLite.isComplete(this.etz.get());
    }

    public boolean aXy() {
        return NotificationLite.isError(this.etz.get());
    }

    boolean a(a<T> aVar) {
        a[] aVarArr;
        Object obj;
        do {
            aVarArr = (a[]) this.subscribers.get();
            if (aVarArr == etO) {
                return false;
            }
            int length = aVarArr.length;
            obj = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, obj, 0, length);
            obj[length] = aVar;
        } while (!this.subscribers.compareAndSet(aVarArr, obj));
        return true;
    }

    void b(a<T> aVar) {
        a[] aVarArr;
        Object obj;
        do {
            aVarArr = (a[]) this.subscribers.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (aVarArr[i2] == aVar) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = etN;
                    } else {
                        Object obj2 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, obj2, 0, i);
                        System.arraycopy(aVarArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            }
            return;
        } while (!this.subscribers.compareAndSet(aVarArr, obj));
    }

    a<T>[] co(Object obj) {
        a[] aVarArr = (a[]) this.subscribers.getAndSet(etO);
        if (aVarArr != etO) {
            cn(obj);
        }
        return aVarArr;
    }

    void cn(Object obj) {
        this.ety.lock();
        this.index++;
        this.etz.lazySet(obj);
        this.ety.unlock();
    }
}
