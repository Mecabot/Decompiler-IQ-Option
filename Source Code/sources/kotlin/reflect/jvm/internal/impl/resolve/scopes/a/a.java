package kotlin.reflect.jvm.internal.impl.resolve.scopes.a;

import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: AbstractReceiverValue */
public abstract class a implements e {
    protected final w eGn;
    private final e eSw;

    public a(w wVar, e eVar) {
        this.eGn = wVar;
        if (eVar == null) {
            eVar = this;
        }
        this.eSw = eVar;
    }

    public w bai() {
        return this.eGn;
    }
}
