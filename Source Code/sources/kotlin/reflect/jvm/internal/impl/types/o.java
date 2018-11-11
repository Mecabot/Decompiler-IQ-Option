package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: ErrorType.kt */
public class o extends ad {
    private final List<ap> eAV;
    private final h eDv;
    private final boolean eRi;
    private final an eUB;

    public o(an anVar, h hVar) {
        this(anVar, hVar, null, false, 12, null);
    }

    public an bwA() {
        return this.eUB;
    }

    public h bbk() {
        return this.eDv;
    }

    public /* synthetic */ o(an anVar, h hVar, List list, boolean z, int i, f fVar) {
        if ((i & 4) != 0) {
            list = m.emptyList();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        this(anVar, hVar, list, z);
    }

    public List<ap> bdF() {
        return this.eAV;
    }

    public boolean aYp() {
        return this.eRi;
    }

    public o(an anVar, h hVar, List<? extends ap> list, boolean z) {
        kotlin.jvm.internal.h.e(anVar, "constructor");
        kotlin.jvm.internal.h.e(hVar, "memberScope");
        kotlin.jvm.internal.h.e(list, "arguments");
        this.eUB = anVar;
        this.eDv = hVar;
        this.eAV = list;
        this.eRi = z;
    }

    public g bbQ() {
        return g.eBF.bel();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bwA().toString());
        stringBuilder.append(bdF().isEmpty() ? "" : u.a(bdF(), ", ", "<", ">", -1, "...", null));
        return stringBuilder.toString();
    }

    /* renamed from: h */
    public ad f(g gVar) {
        kotlin.jvm.internal.h.e(gVar, "newAnnotations");
        return this;
    }

    /* renamed from: gQ */
    public ad gP(boolean z) {
        return new o(bwA(), bbk(), bdF(), z);
    }
}
