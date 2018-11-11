package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.h;
import kotlin.reflect.j;

/* compiled from: storage.kt */
public final class g {
    public static final <T> T a(e<? extends T> eVar, Object obj, j<?> jVar) {
        h.e(eVar, "$receiver");
        h.e(jVar, "p");
        return eVar.invoke();
    }

    public static final <T> T a(f<? extends T> fVar, Object obj, j<?> jVar) {
        h.e(fVar, "$receiver");
        h.e(jVar, "p");
        return fVar.invoke();
    }
}
