package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.h;

/* compiled from: exceptionUtils.kt */
public final class c {
    public static final RuntimeException j(Throwable th) {
        h.e(th, "e");
        throw th;
    }

    public static final boolean ag(Throwable th) {
        h.e(th, "$receiver");
        Class cls = th.getClass();
        while (!h.E(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }
}
