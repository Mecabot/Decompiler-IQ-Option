package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: StubType.kt */
public final class aj extends ad {
    private final h eDv;
    private final boolean eRi;
    private final an eUB;
    private final an eVc;

    public boolean aYp() {
        return this.eRi;
    }

    public an bwA() {
        return this.eUB;
    }

    public h bbk() {
        return this.eDv;
    }

    public aj(an anVar, boolean z, an anVar2, h hVar) {
        kotlin.jvm.internal.h.e(anVar, "originalTypeVariable");
        kotlin.jvm.internal.h.e(anVar2, "constructor");
        kotlin.jvm.internal.h.e(hVar, "memberScope");
        this.eVc = anVar;
        this.eRi = z;
        this.eUB = anVar2;
        this.eDv = hVar;
    }

    public List<ap> bdF() {
        return m.emptyList();
    }

    public g bbQ() {
        return g.eBF.bel();
    }

    /* renamed from: h */
    public ad f(g gVar) {
        kotlin.jvm.internal.h.e(gVar, "newAnnotations");
        throw new IllegalStateException("Shouldn't be called on non-fixed type".toString());
    }

    /* renamed from: gQ */
    public ad gP(boolean z) {
        if (z == aYp()) {
            return this;
        }
        return new aj(this.eVc, z, bwA(), bbk());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NonFixed: ");
        stringBuilder.append(this.eVc);
        return stringBuilder.toString();
    }
}
