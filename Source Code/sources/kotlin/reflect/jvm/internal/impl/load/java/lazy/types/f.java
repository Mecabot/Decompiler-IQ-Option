package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.types.ac;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.b.a;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.q;

/* compiled from: RawType.kt */
public final class f extends q implements ac {
    public f(ad adVar, ad adVar2) {
        h.e(adVar, "lowerBound");
        h.e(adVar2, "upperBound");
        super(adVar, adVar2);
        boolean c = b.eVr.c(adVar, adVar2);
        if (m.etY && !c) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Lower bound ");
            stringBuilder.append(adVar);
            stringBuilder.append(" of a flexible type must be a subtype of the upper bound ");
            stringBuilder.append(adVar2);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public ad bhi() {
        return byT();
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk() {
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = bwA().bbW();
        if (!(bbW instanceof d)) {
            bbW = null;
        }
        d dVar = (d) bbW;
        if (dVar != null) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h a = dVar.a(d.eIr);
            h.d(a, "classDescriptor.getMemberScope(RawSubstitution)");
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Incorrect classifier: ");
        stringBuilder.append(bwA().bbW());
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    /* renamed from: e */
    public f f(g gVar) {
        h.e(gVar, "newAnnotations");
        return new f(byT().h(gVar), byU().h(gVar));
    }

    /* renamed from: gO */
    public f gP(boolean z) {
        return new f(byT().gQ(z), byU().gQ(z));
    }

    public String a(kotlin.reflect.jvm.internal.impl.renderer.b bVar, kotlin.reflect.jvm.internal.impl.renderer.f fVar) {
        h.e(bVar, "renderer");
        h.e(fVar, "options");
        RawTypeImpl$render$1 rawTypeImpl$render$1 = RawTypeImpl$render$1.eIs;
        RawTypeImpl$render$2 rawTypeImpl$render$2 = new RawTypeImpl$render$2(bVar);
        RawTypeImpl$render$3 rawTypeImpl$render$3 = RawTypeImpl$render$3.eIt;
        String b = bVar.b(byT());
        String b2 = bVar.b(byU());
        if (fVar.HW()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("raw (");
            stringBuilder.append(b);
            stringBuilder.append("..");
            stringBuilder.append(b2);
            stringBuilder.append(')');
            return stringBuilder.toString();
        } else if (byU().bdF().isEmpty()) {
            return bVar.a(b, b2, a.bj(this));
        } else {
            List ab = rawTypeImpl$render$2.invoke(byT());
            List ab2 = rawTypeImpl$render$2.invoke(byU());
            Iterable iterable = ab;
            String a = u.a(iterable, ", ", null, null, 0, null, RawTypeImpl$render$newArgs$1.eIu, 30, null);
            Iterable<Pair> f = u.f(iterable, (Iterable) ab2);
            Object obj = 1;
            if (!(f instanceof Collection) || !((Collection) f).isEmpty()) {
                for (Pair pair : f) {
                    if (!RawTypeImpl$render$1.eIs.ba((String) pair.getFirst(), (String) pair.aXF())) {
                        obj = null;
                        break;
                    }
                }
            }
            if (obj != null) {
                b2 = rawTypeImpl$render$3.B(b2, a);
            }
            String bb = rawTypeImpl$render$3.B(b, a);
            if (h.E(bb, b2)) {
                return bb;
            }
            return bVar.a(bb, b2, a.bj(this));
        }
    }
}
