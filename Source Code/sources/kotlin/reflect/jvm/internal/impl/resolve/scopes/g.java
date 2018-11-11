package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.storage.e;

/* compiled from: LazyScopeAdapter.kt */
public final class g extends a {
    private final e<h> eSh;

    public g(e<? extends h> eVar) {
        h.e(eVar, "scope");
        this.eSh = eVar;
    }

    protected h bwL() {
        return (h) this.eSh.invoke();
    }
}
