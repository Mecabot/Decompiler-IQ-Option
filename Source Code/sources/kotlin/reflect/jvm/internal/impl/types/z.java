package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.a.a;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: SpecialTypes.kt */
public final class z extends az {
    private final e<w> eUY;

    public z(h hVar, a<? extends w> aVar) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(aVar, "computation");
        this.eUY = hVar.i(aVar);
    }

    protected w bzd() {
        return (w) this.eUY.invoke();
    }

    public boolean byE() {
        return this.eUY.byE();
    }
}
