package io.reactivex.internal.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ListCompositeDisposable */
public final class b implements io.reactivex.disposables.b, a {
    volatile boolean disposed;
    List<io.reactivex.disposables.b> eqn;

    public void dispose() {
        if (!this.disposed) {
            synchronized (this) {
                if (this.disposed) {
                    return;
                }
                this.disposed = true;
                List list = this.eqn;
                this.eqn = null;
                bP(list);
            }
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean e(io.reactivex.disposables.b bVar) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "d is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    List list = this.eqn;
                    if (list == null) {
                        list = new LinkedList();
                        this.eqn = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    public boolean f(io.reactivex.disposables.b bVar) {
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
        r0 = r2.eqn;	 Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.disposables.b.g(io.reactivex.disposables.b):boolean");
    }

    void bP(List<io.reactivex.disposables.b> list) {
        if (list != null) {
            Iterable iterable = null;
            for (io.reactivex.disposables.b dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th) {
                    a.V(th);
                    if (iterable == null) {
                        iterable = new ArrayList();
                    }
                    iterable.add(th);
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
