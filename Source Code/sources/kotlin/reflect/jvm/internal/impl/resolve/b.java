package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.aa;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ab;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.f;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.z;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: DescriptorFactory */
public class b {

    /* compiled from: DescriptorFactory */
    private static class a extends f {
        public a(d dVar, ai aiVar) {
            super(dVar, null, g.eBF.bel(), true, Kind.DECLARATION, aiVar);
            a(Collections.emptyList(), c.J(dVar));
        }
    }

    public static aa a(ad adVar, g gVar) {
        return a(adVar, gVar, true, false, false, adVar.bbR());
    }

    public static aa a(ad adVar, g gVar, boolean z, boolean z2, boolean z3, ai aiVar) {
        return a(adVar, gVar, z, z2, z3, adVar.bbJ(), aiVar);
    }

    public static aa a(ad adVar, g gVar, boolean z, boolean z2, boolean z3, av avVar, ai aiVar) {
        aa aaVar = new aa(adVar, gVar, adVar.bbG(), avVar, z, z2, z3, Kind.DECLARATION, null, aiVar);
        aaVar.bfg();
        return aaVar;
    }

    public static z b(ad adVar, g gVar) {
        return a(adVar, gVar, true, false, false);
    }

    public static z a(ad adVar, g gVar, boolean z, boolean z2, boolean z3) {
        return b(adVar, gVar, z, z2, z3, adVar.bbR());
    }

    public static z b(ad adVar, g gVar, boolean z, boolean z2, boolean z3, ai aiVar) {
        return new z(adVar, gVar, adVar.bbG(), adVar.bbJ(), z, z2, z3, Kind.DECLARATION, null, aiVar);
    }

    public static f a(d dVar, ai aiVar) {
        return new a(dVar, aiVar);
    }

    public static ah G(d dVar) {
        return ac.a((k) dVar, g.eBF.bel(), c.eQA, Kind.SYNTHESIZED, dVar.bbR()).a(null, null, Collections.emptyList(), Collections.emptyList(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(dVar).a(Variance.INVARIANT, dVar.bdb()), Modality.FINAL, au.eBg);
    }

    public static ah H(d dVar) {
        ac a = ac.a((k) dVar, g.eBF.bel(), c.eQB, Kind.SYNTHESIZED, dVar.bbR());
        return a.a(null, null, Collections.emptyList(), Collections.singletonList(new kotlin.reflect.jvm.internal.impl.descriptors.impl.ah(a, null, 0, g.eBF.bel(), kotlin.reflect.jvm.internal.impl.name.f.mD(com.google.firebase.analytics.FirebaseAnalytics.b.VALUE), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(dVar).bbg(), false, false, false, null, dVar.bbR())), dVar.bdb(), Modality.FINAL, au.eBg);
    }

    public static boolean j(r rVar) {
        return rVar.bdc().equals(c.eQA) && l(rVar);
    }

    public static boolean k(r rVar) {
        return rVar.bdc().equals(c.eQB) && l(rVar);
    }

    private static boolean l(r rVar) {
        return rVar.bcW() == Kind.SYNTHESIZED && c.H(rVar.bbv());
    }

    public static ag a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, w wVar) {
        return wVar == null ? null : new ab(aVar, new kotlin.reflect.jvm.internal.impl.resolve.scopes.a.b(aVar, wVar, null));
    }
}
