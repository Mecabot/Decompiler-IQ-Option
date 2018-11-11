package org.threeten.bp.format;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DateTimeTextProvider */
public abstract class e {
    private static final AtomicReference<e> fgs = new AtomicReference();

    /* compiled from: DateTimeTextProvider */
    static class a {
        static final e fgt = bDo();

        static e bDo() {
            e.fgs.compareAndSet(null, new g());
            return (e) e.fgs.get();
        }
    }

    public abstract String a(org.threeten.bp.temporal.e eVar, long j, TextStyle textStyle, Locale locale);

    static e bDm() {
        return a.fgt;
    }
}
