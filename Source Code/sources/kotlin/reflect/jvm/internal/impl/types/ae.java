package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.p.b;

/* compiled from: KotlinTypeFactory.kt */
final class ae extends ad {
    private final List<ap> eAV;
    private final h eDv;
    private final boolean eRi;
    private final an eUB;

    public an bwA() {
        return this.eUB;
    }

    public List<ap> bdF() {
        return this.eAV;
    }

    public boolean aYp() {
        return this.eRi;
    }

    public h bbk() {
        return this.eDv;
    }

    public ae(an anVar, List<? extends ap> list, boolean z, h hVar) {
        kotlin.jvm.internal.h.e(anVar, "constructor");
        kotlin.jvm.internal.h.e(list, "arguments");
        kotlin.jvm.internal.h.e(hVar, "memberScope");
        this.eUB = anVar;
        this.eAV = list;
        this.eRi = z;
        this.eDv = hVar;
        if (bbk() instanceof b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SimpleTypeImpl should not be created for error type: ");
            stringBuilder.append(bbk());
            stringBuilder.append(10);
            stringBuilder.append(bwA());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public g bbQ() {
        return g.eBF.bel();
    }

    /* renamed from: h */
    public ad f(g gVar) {
        kotlin.jvm.internal.h.e(gVar, "newAnnotations");
        if (gVar.isEmpty()) {
            return this;
        }
        return new d(this, gVar);
    }

    /* renamed from: gQ */
    public ad gP(boolean z) {
        if (z == aYp()) {
            return this;
        }
        j abVar;
        if (z) {
            abVar = new ab(this);
        } else {
            abVar = new aa(this);
        }
        return abVar;
    }
}
