package io.reactivex.internal.subscriptions;

import io.reactivex.d.a;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.a.b;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

public enum SubscriptionHelper implements d {
    CANCELLED;

    public void cancel() {
    }

    public void request(long j) {
    }

    public static boolean validate(d dVar, d dVar2) {
        if (dVar2 == null) {
            a.onError(new NullPointerException("next is null"));
            return false;
        } else if (dVar == null) {
            return true;
        } else {
            dVar2.cancel();
            reportSubscriptionSet();
            return false;
        }
    }

    public static void reportSubscriptionSet() {
        a.onError(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("n > 0 required but it was ");
        stringBuilder.append(j);
        a.onError(new IllegalArgumentException(stringBuilder.toString()));
        return false;
    }

    public static void reportMoreProduced(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("More produced than requested: ");
        stringBuilder.append(j);
        a.onError(new ProtocolViolationException(stringBuilder.toString()));
    }

    public static boolean isCancelled(d dVar) {
        return dVar == CANCELLED;
    }

    public static boolean set(AtomicReference<d> atomicReference, d dVar) {
        d dVar2;
        do {
            dVar2 = (d) atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar != null) {
                    dVar.cancel();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        if (dVar2 != null) {
            dVar2.cancel();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<d> atomicReference, d dVar) {
        b.requireNonNull(dVar, "s is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != CANCELLED) {
            reportSubscriptionSet();
        }
        return false;
    }

    public static boolean replace(AtomicReference<d> atomicReference, d dVar) {
        d dVar2;
        do {
            dVar2 = (d) atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar != null) {
                    dVar.cancel();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        return true;
    }

    public static boolean cancel(AtomicReference<d> atomicReference) {
        if (((d) atomicReference.get()) != CANCELLED) {
            d dVar = (d) atomicReference.getAndSet(CANCELLED);
            if (dVar != CANCELLED) {
                if (dVar != null) {
                    dVar.cancel();
                }
                return true;
            }
        }
        return false;
    }

    public static boolean deferredSetOnce(AtomicReference<d> atomicReference, AtomicLong atomicLong, d dVar) {
        if (!setOnce(atomicReference, dVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet != 0) {
            dVar.request(andSet);
        }
        return true;
    }

    public static void deferredRequest(AtomicReference<d> atomicReference, AtomicLong atomicLong, long j) {
        d dVar = (d) atomicReference.get();
        if (dVar != null) {
            dVar.request(j);
        } else if (validate(j)) {
            io.reactivex.internal.util.b.a(atomicLong, j);
            d dVar2 = (d) atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    dVar2.request(andSet);
                }
            }
        }
    }

    public static boolean setOnce(AtomicReference<d> atomicReference, d dVar, long j) {
        if (!setOnce(atomicReference, dVar)) {
            return false;
        }
        dVar.request(j);
        return true;
    }
}
