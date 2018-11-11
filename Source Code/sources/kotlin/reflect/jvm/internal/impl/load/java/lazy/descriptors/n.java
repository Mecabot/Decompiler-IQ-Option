package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.b;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.e;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.j;
import kotlin.reflect.jvm.internal.impl.load.java.structure.v;
import kotlin.reflect.jvm.internal.impl.load.java.structure.w;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
public final class n extends b {
    private final h eGT;
    private final e eIh = new e(this.eGT, this.eIi);
    private final w eIi;

    protected void P(kotlin.reflect.jvm.internal.impl.types.w wVar) {
        kotlin.jvm.internal.h.e(wVar, Param.TYPE);
    }

    public n(h hVar, w wVar, int i, k kVar) {
        kotlin.jvm.internal.h.e(hVar, "c");
        kotlin.jvm.internal.h.e(wVar, "javaTypeParameter");
        kotlin.jvm.internal.h.e(kVar, "containingDeclaration");
        super(hVar.baI(), kVar, wVar.bdc(), Variance.INVARIANT, false, i, ai.eAX, hVar.bgq().bbZ());
        this.eGT = hVar;
        this.eIi = wVar;
    }

    /* renamed from: bhb */
    public e bbQ() {
        return this.eIh;
    }

    protected List<kotlin.reflect.jvm.internal.impl.types.w> bev() {
        Collection bhK = this.eIi.bhK();
        if (bhK.isEmpty()) {
            ad baU = this.eGT.bar().bdy().baU();
            kotlin.jvm.internal.h.d(baU, "c.module.builtIns.anyType");
            ad baV = this.eGT.bar().bdy().baV();
            kotlin.jvm.internal.h.d(baV, "c.module.builtIns.nullableAnyType");
            return l.cr(x.a(baU, baV));
        }
        Iterable<j> iterable = bhK;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (j a : iterable) {
            arrayList.add(this.eGT.bgp().a((v) a, c.a(TypeUsage.COMMON, false, (an) this, 1, null)));
        }
        return (List) arrayList;
    }
}
