package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.a.b;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.e;
import java.util.ArrayList;

/* compiled from: CompositeDisposable */
public final class a implements b, io.reactivex.internal.disposables.a {
    volatile boolean disposed;
    e<b> eqk;

    public void dispose() {
        if (!this.disposed) {
            synchronized (this) {
                if (this.disposed) {
                    return;
                }
                this.disposed = true;
                e eVar = this.eqk;
                this.eqk = null;
                a(eVar);
            }
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean e(b bVar) {
        b.requireNonNull(bVar, "d is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    e eVar = this.eqk;
                    if (eVar == null) {
                        eVar = new e();
                        this.eqk = eVar;
                    }
                    eVar.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    public boolean f(b bVar) {
        if (!g(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    /* JADX WARNING: Missing block: B:17:0x0021, code:
            return false;
     */
    public boolean g(io.reactivex.disposables.b r3) {
        /*
        r2 = this;
        r0 = "Disposable item is null";
        io.reactivex.internal.a.b.requireNonNull(r3, r0);
        r0 = r2.disposed;
        r1 = 0;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        monitor-enter(r2);
        r0 = r2.disposed;	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        return r1;
    L_0x0012:
        r0 = r2.eqk;	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0020;
    L_0x0016:
        r3 = r0.remove(r3);	 Catch:{ all -> 0x0022 }
        if (r3 != 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0020;
    L_0x001d:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        r3 = 1;
        return r3;
    L_0x0020:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        return r1;
    L_0x0022:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.a.g(io.reactivex.disposables.b):boolean");
    }

    public void clear() {
        if (!this.disposed) {
            synchronized (this) {
                if (this.disposed) {
                    return;
                }
                e eVar = this.eqk;
                this.eqk = null;
                a(eVar);
            }
        }
    }

    void a(e<b> eVar) {
        if (eVar != null) {
            Iterable iterable = null;
            for (Object obj : eVar.keys()) {
                if (obj instanceof b) {
                    try {
                        ((b) obj).dispose();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        if (iterable == null) {
                            iterable = new ArrayList();
                        }
                        iterable.add(th);
                    }
                }
            }
            if (iterable == null) {
                return;
            }
            if (iterable.size() == 1) {
                throw ExceptionHelper.Z((Throwable) iterable.get(0));
            }
            throw new CompositeException(iterable);
        }
    }
}
