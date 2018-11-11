package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a.a;
import io.reactivex.m;

/* compiled from: SerializedSubject */
final class b<T> extends c<T> implements a<Object> {
    volatile boolean done;
    boolean emitting;
    final c<T> etU;
    io.reactivex.internal.util.a<Object> queue;

    b(c<T> cVar) {
        this.etU = cVar;
    }

    protected void b(m<? super T> mVar) {
        this.etU.a((m) mVar);
    }

    public void d(io.reactivex.disposables.b bVar) {
        boolean z = true;
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        io.reactivex.internal.util.a aVar = this.queue;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a(4);
                            this.queue = aVar;
                        }
                        aVar.add(NotificationLite.disposable(bVar));
                        return;
                    }
                    this.emitting = true;
                    z = false;
                }
            }
        }
        if (z) {
            bVar.dispose();
        } else {
            this.etU.d(bVar);
            aXo();
        }
    }

    public void e(T t) {
        if (!this.done) {
            synchronized (this) {
                if (this.done) {
                } else if (this.emitting) {
                    io.reactivex.internal.util.a aVar = this.queue;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a(4);
                        this.queue = aVar;
                    }
                    aVar.add(NotificationLite.next(t));
                } else {
                    this.emitting = true;
                    this.etU.e(t);
                    aXo();
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:19:0x002f, code:
            if (r0 == null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:20:0x0031, code:
            io.reactivex.d.a.onError(r3);
     */
    /* JADX WARNING: Missing block: B:21:0x0034, code:
            return;
     */
    /* JADX WARNING: Missing block: B:22:0x0035, code:
            r2.etU.onError(r3);
     */
    /* JADX WARNING: Missing block: B:23:0x003a, code:
            return;
     */
    public void onError(java.lang.Throwable r3) {
        /*
        r2 = this;
        r0 = r2.done;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        io.reactivex.d.a.onError(r3);
        return;
    L_0x0008:
        monitor-enter(r2);
        r0 = r2.done;	 Catch:{ all -> 0x003b }
        r1 = 1;
        if (r0 == 0) goto L_0x0010;
    L_0x000e:
        r0 = 1;
        goto L_0x002e;
    L_0x0010:
        r2.done = r1;	 Catch:{ all -> 0x003b }
        r0 = r2.emitting;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x002b;
    L_0x0016:
        r0 = r2.queue;	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x0022;
    L_0x001a:
        r0 = new io.reactivex.internal.util.a;	 Catch:{ all -> 0x003b }
        r1 = 4;
        r0.<init>(r1);	 Catch:{ all -> 0x003b }
        r2.queue = r0;	 Catch:{ all -> 0x003b }
    L_0x0022:
        r3 = io.reactivex.internal.util.NotificationLite.error(r3);	 Catch:{ all -> 0x003b }
        r0.ck(r3);	 Catch:{ all -> 0x003b }
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        return;
    L_0x002b:
        r0 = 0;
        r2.emitting = r1;	 Catch:{ all -> 0x003b }
    L_0x002e:
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x0035;
    L_0x0031:
        io.reactivex.d.a.onError(r3);
        return;
    L_0x0035:
        r0 = r2.etU;
        r0.onError(r3);
        return;
    L_0x003b:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.b.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.done) {
            synchronized (this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                if (this.emitting) {
                    io.reactivex.internal.util.a aVar = this.queue;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a(4);
                        this.queue = aVar;
                    }
                    aVar.add(NotificationLite.complete());
                    return;
                }
                this.emitting = true;
                this.etU.onComplete();
            }
        }
    }

    void aXo() {
        while (true) {
            io.reactivex.internal.util.a aVar;
            synchronized (this) {
                aVar = this.queue;
                if (aVar == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
            aVar.a(this);
        }
        while (true) {
        }
    }

    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.etU);
    }

    public boolean aXy() {
        return this.etU.aXy();
    }

    public boolean aXx() {
        return this.etU.aXx();
    }
}
