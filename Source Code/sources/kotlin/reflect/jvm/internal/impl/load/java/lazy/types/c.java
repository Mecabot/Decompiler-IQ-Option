package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.types.ah;
import kotlin.reflect.jvm.internal.impl.types.ai;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: JavaTypeResolver.kt */
public final class c {
    private static final b eIo = new b("java.lang.Class");

    public static final ap a(an anVar, a aVar) {
        h.e(anVar, "typeParameter");
        h.e(aVar, "attr");
        if (aVar.bhc() == TypeUsage.SUPERTYPE) {
            return new ar(ai.d(anVar));
        }
        return new ah(anVar);
    }

    public static final a a(TypeUsage typeUsage, boolean z, an anVar) {
        h.e(typeUsage, "$receiver");
        return new a(typeUsage, null, z, anVar, 2, null);
    }

    public static final w a(an anVar, an anVar2, a<? extends w> aVar) {
        h.e(anVar, "$receiver");
        h.e(aVar, "defaultValue");
        if (anVar == anVar2) {
            return (w) aVar.invoke();
        }
        List aYq = anVar.aYq();
        h.d(aYq, "upperBounds");
        w wVar = (w) u.bU(aYq);
        if (wVar.bwA().bbW() instanceof d) {
            h.d(wVar, "firstUpperBound");
            return kotlin.reflect.jvm.internal.impl.types.b.a.bl(wVar);
        }
        Object anVar3;
        if (anVar2 != null) {
            anVar3 = anVar2;
        }
        f bbW = wVar.bwA().bbW();
        if (bbW == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
        while (true) {
            anVar2 = (an) bbW;
            if ((h.E(anVar2, anVar3) ^ 1) == 0) {
                return (w) aVar.invoke();
            }
            List aYq2 = anVar2.aYq();
            h.d(aYq2, "current.upperBounds");
            w wVar2 = (w) u.bU(aYq2);
            if (wVar2.bwA().bbW() instanceof d) {
                h.d(wVar2, "nextUpperBound");
                return kotlin.reflect.jvm.internal.impl.types.b.a.bl(wVar2);
            }
            bbW = wVar2.bwA().bbW();
            if (bbW == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            }
        }
    }
}
