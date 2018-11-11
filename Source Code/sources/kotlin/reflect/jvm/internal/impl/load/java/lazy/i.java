package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n;
import kotlin.reflect.jvm.internal.impl.load.java.structure.w;
import kotlin.reflect.jvm.internal.impl.load.java.structure.x;
import kotlin.reflect.jvm.internal.impl.storage.c;
import kotlin.reflect.jvm.internal.impl.utils.a;

/* compiled from: resolvers.kt */
public final class i implements m {
    private final k eCq;
    private final h eGT;
    private final Map<w, Integer> eHb;
    private final c<w, n> eHc = this.eGT.baI().p(new LazyJavaTypeParameterResolver$resolve$1(this));
    private final int eHd;

    public i(h hVar, k kVar, x xVar, int i) {
        h.e(hVar, "c");
        h.e(kVar, "containingDeclaration");
        h.e(xVar, "typeParameterOwner");
        this.eGT = hVar;
        this.eCq = kVar;
        this.eHd = i;
        this.eHb = a.ah(xVar.getTypeParameters());
    }

    public an a(w wVar) {
        h.e(wVar, "javaTypeParameter");
        n nVar = (n) this.eHc.invoke(wVar);
        return nVar != null ? nVar : this.eGT.bgr().a(wVar);
    }
}
