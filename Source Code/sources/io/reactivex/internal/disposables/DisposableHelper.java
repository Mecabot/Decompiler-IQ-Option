package io.reactivex.internal.disposables;

import io.reactivex.d.a;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

public enum DisposableHelper implements b {
    DISPOSED;

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public static boolean isDisposed(b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean set(AtomicReference<b> atomicReference, b bVar) {
        b bVar2;
        do {
            bVar2 = (b) atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 != null) {
            bVar2.dispose();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<b> atomicReference, b bVar) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DISPOSED) {
            reportDisposableSet();
        }
        return false;
    }

    public static boolean replace(AtomicReference<b> atomicReference, b bVar) {
        b bVar2;
        do {
            bVar2 = (b) atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static boolean dispose(AtomicReference<b> atomicReference) {
        b bVar = (b) atomicReference.get();
        b bVar2 = DISPOSED;
        if (bVar != bVar2) {
            b bVar3 = (b) atomicReference.getAndSet(bVar2);
            if (bVar3 != bVar2) {
                if (bVar3 != null) {
                    bVar3.dispose();
                }
                return true;
            }
        }
        return false;
    }

    public static boolean validate(b bVar, b bVar2) {
        if (bVar2 == null) {
            a.onError(new NullPointerException("next is null"));
            return false;
        } else if (bVar == null) {
            return true;
        } else {
            bVar2.dispose();
            reportDisposableSet();
            return false;
        }
    }

    public static void reportDisposableSet() {
        a.onError(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<b> atomicReference, b bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            bVar.dispose();
        }
        return false;
    }
}
