package org.threeten.bp.zone;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ZoneRulesInitializer */
public abstract class b {
    public static final b fha = new a();
    private static final AtomicBoolean fhb = new AtomicBoolean(false);
    private static final AtomicReference<b> fhc = new AtomicReference();

    /* compiled from: ZoneRulesInitializer */
    static class a extends b {
        protected void aOC() {
        }

        a() {
        }
    }

    /* compiled from: ZoneRulesInitializer */
    static class b extends b {
        b() {
        }

        protected void aOC() {
            Iterator it = ServiceLoader.load(c.class, c.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                try {
                    c.a((c) it.next());
                } catch (ServiceConfigurationError e) {
                    if (!(e.getCause() instanceof SecurityException)) {
                        throw e;
                    }
                }
            }
        }
    }

    protected abstract void aOC();

    public static void a(b bVar) {
        if (fhb.get()) {
            throw new IllegalStateException("Already initialized");
        } else if (!fhc.compareAndSet(null, bVar)) {
            throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
        }
    }

    static void initialize() {
        if (fhb.getAndSet(true)) {
            throw new IllegalStateException("Already initialized");
        }
        fhc.compareAndSet(null, new b());
        ((b) fhc.get()).aOC();
    }
}
