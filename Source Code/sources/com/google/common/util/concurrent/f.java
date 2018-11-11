package com.google.common.util.concurrent;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: AggregateFutureState */
abstract class f {
    private static final a WD;
    private static final Logger log = Logger.getLogger(f.class.getName());
    private volatile int Rc;
    private volatile Set<Throwable> WC = null;

    /* compiled from: AggregateFutureState */
    private static abstract class a {
        abstract void a(f fVar, Set<Throwable> set, Set<Throwable> set2);

        abstract int d(f fVar);

        private a() {
        }
    }

    /* compiled from: AggregateFutureState */
    private static final class b extends a {
        final AtomicReferenceFieldUpdater<f, Set<Throwable>> WE;
        final AtomicIntegerFieldUpdater<f> WG;

        b(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.WE = atomicReferenceFieldUpdater;
            this.WG = atomicIntegerFieldUpdater;
        }

        void a(f fVar, Set<Throwable> set, Set<Throwable> set2) {
            this.WE.compareAndSet(fVar, set, set2);
        }

        int d(f fVar) {
            return this.WG.decrementAndGet(fVar);
        }
    }

    /* compiled from: AggregateFutureState */
    private static final class c extends a {
        private c() {
            super();
        }

        void a(f fVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (fVar) {
                if (fVar.WC == set) {
                    fVar.WC = set2;
                }
            }
        }

        int d(f fVar) {
            int c;
            synchronized (fVar) {
                fVar.Rc = fVar.Rc - 1;
                c = fVar.Rc;
            }
            return c;
        }
    }

    abstract void e(Set<Throwable> set);

    static {
        a bVar;
        Throwable th = null;
        try {
            bVar = new b(AtomicReferenceFieldUpdater.newUpdater(f.class, Set.class, "WC"), AtomicIntegerFieldUpdater.newUpdater(f.class, "Rc"));
        } catch (Throwable th2) {
            th = th2;
            bVar = new c();
        }
        WD = bVar;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    f(int i) {
        this.Rc = i;
    }

    final Set<Throwable> vP() {
        Set<Throwable> set = this.WC;
        if (set != null) {
            return set;
        }
        Set uJ = Sets.uJ();
        e(uJ);
        WD.a(this, null, uJ);
        return this.WC;
    }

    final int vQ() {
        return WD.d(this);
    }
}
