package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.j;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.a;
import kotlin.reflect.jvm.internal.impl.load.java.structure.d;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: JavaAnnotationMapper.kt */
public final class c {
    private static final b eFS = new b(Target.class.getCanonicalName());
    private static final b eFT = new b(Retention.class.getCanonicalName());
    private static final b eFU = new b(Deprecated.class.getCanonicalName());
    private static final b eFV = new b(Documented.class.getCanonicalName());
    private static final b eFW = new b("java.lang.annotation.Repeatable");
    private static final f eFX = f.mD("message");
    private static final f eFY = f.mD("allowedTargets");
    private static final f eFZ = f.mD(FirebaseAnalytics.b.VALUE);
    private static final Map<b, b> eGa = ad.a(j.D(g.exC.eym, eFS), j.D(g.exC.eyp, eFT), j.D(g.exC.eyq, eFW), j.D(g.exC.eyr, eFV));
    private static final Map<b, b> eGb = ad.a(j.D(eFS, g.exC.eym), j.D(eFT, g.exC.eyp), j.D(eFU, g.exC.eyg), j.D(eFW, g.exC.eyq), j.D(eFV, g.exC.eyr));
    public static final c eGc = new c();

    private c() {
    }

    public final f bfP() {
        return eFX;
    }

    public final f bfQ() {
        return eFY;
    }

    public final f bfR() {
        return eFZ;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(a aVar, h hVar) {
        kotlin.jvm.internal.h.e(aVar, "annotation");
        kotlin.jvm.internal.h.e(hVar, "c");
        kotlin.reflect.jvm.internal.impl.name.a classId = aVar.getClassId();
        if (kotlin.jvm.internal.h.E(classId, kotlin.reflect.jvm.internal.impl.name.a.t(eFS))) {
            return new i(aVar, hVar);
        }
        if (kotlin.jvm.internal.h.E(classId, kotlin.reflect.jvm.internal.impl.name.a.t(eFT))) {
            return new h(aVar, hVar);
        }
        b bVar;
        if (kotlin.jvm.internal.h.E(classId, kotlin.reflect.jvm.internal.impl.name.a.t(eFW))) {
            bVar = g.exC.eyq;
            kotlin.jvm.internal.h.d(bVar, "KotlinBuiltIns.FQ_NAMES.repeatable");
            return new b(hVar, aVar, bVar);
        } else if (kotlin.jvm.internal.h.E(classId, kotlin.reflect.jvm.internal.impl.name.a.t(eFV))) {
            bVar = g.exC.eyr;
            kotlin.jvm.internal.h.d(bVar, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
            return new b(hVar, aVar, bVar);
        } else if (kotlin.jvm.internal.h.E(classId, kotlin.reflect.jvm.internal.impl.name.a.t(eFU))) {
            return null;
        } else {
            return new e(hVar, aVar);
        }
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(b bVar, d dVar, h hVar) {
        kotlin.jvm.internal.h.e(bVar, "kotlinName");
        kotlin.jvm.internal.h.e(dVar, "annotationOwner");
        kotlin.jvm.internal.h.e(hVar, "c");
        if (kotlin.jvm.internal.h.E(bVar, g.exC.eyg)) {
            a r = dVar.r(eFU);
            if (r != null || dVar.bhm()) {
                return new e(r, hVar);
            }
        }
        bVar = (b) eGa.get(bVar);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar = null;
        if (bVar != null) {
            a r2 = dVar.r(bVar);
            if (r2 != null) {
                cVar = eGc.a(r2, hVar);
            }
        }
        return cVar;
    }
}
