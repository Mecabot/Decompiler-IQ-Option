package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {
    public static final Throwable esW = new Termination();

    static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Throwable fillInStackTrace() {
            return this;
        }

        Termination() {
            super("No further exceptions");
        }
    }

    public static RuntimeException Z(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        } else {
            return new RuntimeException(th);
        }
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Object obj;
        do {
            th2 = (Throwable) atomicReference.get();
            if (th2 == esW) {
                return false;
            }
            if (th2 == null) {
                obj = th;
            } else {
                obj = new CompositeException(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, obj));
        return true;
    }

    public static <T> Throwable a(AtomicReference<Throwable> atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        return th != esW ? (Throwable) atomicReference.getAndSet(esW) : th;
    }

    public static <E extends Throwable> Exception aa(Throwable th) {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }
}
