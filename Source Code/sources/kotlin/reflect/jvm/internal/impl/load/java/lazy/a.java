package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.d;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.x;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* compiled from: context.kt */
public final class a {
    public static final h a(h hVar, m mVar) {
        h.e(hVar, "$receiver");
        h.e(mVar, "typeParameterResolver");
        return new h(hVar.bgq(), mVar, hVar.bgs());
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099  */
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.d a(kotlin.reflect.jvm.internal.impl.load.java.lazy.h r5, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r6) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r5, r0);
        r0 = "additionalAnnotations";
        kotlin.jvm.internal.h.e(r6, r0);
        r0 = r5.bgq();
        r0 = r0.bgh();
        r0 = r0.getDisabled();
        if (r0 == 0) goto L_0x001d;
    L_0x0018:
        r5 = r5.bgo();
        return r5;
    L_0x001d:
        r6 = (java.lang.Iterable) r6;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.Collection) r0;
        r6 = r6.iterator();
    L_0x002a:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x0040;
    L_0x0030:
        r1 = r6.next();
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) r1;
        r1 = a(r5, r1);
        if (r1 == 0) goto L_0x002a;
    L_0x003c:
        r0.add(r1);
        goto L_0x002a;
    L_0x0040:
        r0 = (java.util.List) r0;
        r6 = r0.isEmpty();
        if (r6 == 0) goto L_0x004d;
    L_0x0048:
        r5 = r5.bgo();
        return r5;
    L_0x004d:
        r6 = r5.bgo();
        if (r6 == 0) goto L_0x005f;
    L_0x0053:
        r6 = r6.bgm();
        if (r6 == 0) goto L_0x005f;
    L_0x0059:
        r1 = new java.util.EnumMap;
        r1.<init>(r6);
        goto L_0x0066;
    L_0x005f:
        r1 = new java.util.EnumMap;
        r6 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType.class;
        r1.<init>(r6);
    L_0x0066:
        r6 = 0;
        r0 = r0.iterator();
    L_0x006b:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0097;
    L_0x0071:
        r2 = r0.next();
        r2 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.k) r2;
        r3 = r2.bgt();
        r2 = r2.bgu();
        r2 = r2.iterator();
    L_0x0083:
        r4 = r2.hasNext();
        if (r4 == 0) goto L_0x006b;
    L_0x0089:
        r6 = r2.next();
        r6 = (kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType) r6;
        r4 = r1;
        r4 = (java.util.Map) r4;
        r4.put(r6, r3);
        r6 = 1;
        goto L_0x0083;
    L_0x0097:
        if (r6 != 0) goto L_0x009e;
    L_0x0099:
        r5 = r5.bgo();
        goto L_0x00a3;
    L_0x009e:
        r5 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.d;
        r5.<init>(r1);
    L_0x00a3:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.a.a(kotlin.reflect.jvm.internal.impl.load.java.lazy.h, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g):kotlin.reflect.jvm.internal.impl.load.java.lazy.d");
    }

    private static final k a(h hVar, c cVar) {
        AnnotationTypeQualifierResolver bgh = hVar.bgq().bgh();
        k d = bgh.d(cVar);
        if (d != null) {
            return d;
        }
        kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.a e = bgh.e(cVar);
        if (e == null) {
            return null;
        }
        c beh = e.beh();
        List bdz = e.bdz();
        ReportLevel g = bgh.g(cVar);
        if (g == null) {
            g = bgh.f(beh);
        }
        if (g.isIgnore()) {
            return null;
        }
        f i = hVar.bgq().bgi().i(beh);
        if (i != null) {
            i = f.a(i, null, g.isWarning(), 1, null);
            if (i != null) {
                return new k(i, bdz);
            }
        }
        return null;
    }

    public static final h a(h hVar, b bVar) {
        h.e(hVar, "$receiver");
        h.e(bVar, "components");
        return new h(bVar, hVar.bgr(), hVar.bgs());
    }

    private static final h a(h hVar, k kVar, x xVar, int i, d<d> dVar) {
        m iVar;
        b bgq = hVar.bgq();
        if (xVar != null) {
            iVar = new i(hVar, kVar, xVar, i);
        } else {
            iVar = hVar.bgr();
        }
        return new h(bgq, iVar, dVar);
    }

    public static final h a(h hVar, k kVar, x xVar, int i) {
        h.e(hVar, "$receiver");
        h.e(kVar, "containingDeclaration");
        h.e(xVar, "typeParameterOwner");
        return a(hVar, kVar, xVar, i, hVar.bgs());
    }

    public static final h a(h hVar, e eVar, x xVar, int i) {
        h.e(hVar, "$receiver");
        h.e(eVar, "containingDeclaration");
        return a(hVar, eVar, xVar, i, g.a(LazyThreadSafetyMode.NONE, new ContextKt$childForClassOrPackage$1(hVar, eVar)));
    }

    public static final h b(h hVar, g gVar) {
        h.e(hVar, "$receiver");
        h.e(gVar, "additionalAnnotations");
        return gVar.isEmpty() ? hVar : new h(hVar.bgq(), hVar.bgr(), g.a(LazyThreadSafetyMode.NONE, new ContextKt$copyWithNewDefaultTypeQualifiers$1(hVar, gVar)));
    }
}
